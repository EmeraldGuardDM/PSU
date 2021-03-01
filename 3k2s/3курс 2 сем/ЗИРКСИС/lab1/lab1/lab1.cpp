#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <openssl/rsa.h>
#include <openssl/engine.h>
#include <openssl/pem.h>
#include "base64.h"
#define PADDING RSA_PKCS1_PADDING

RSA* loadPUBLICKeyFromString(const char* publicKeyStr)
{
	BIO* bio = BIO_new_mem_buf((void*)publicKeyStr, -1);

	BIO_set_flags(bio, BIO_FLAGS_BASE64_NO_NL); 
	RSA* rsaPubKey = PEM_read_bio_RSA_PUBKEY(bio, NULL, NULL, NULL);
	if (!rsaPubKey)
		printf("ERROR: Could not load PUBLIC KEY!  PEM_read_bio_RSA_PUBKEY FAILED: %s\n", ERR_error_string(ERR_get_error(), NULL));

	BIO_free(bio);
	return rsaPubKey;
}

RSA* loadPRIVATEKeyFromString(const char* privateKeyStr)
{
	BIO *bio = BIO_new_mem_buf((void*)privateKeyStr, -1);
	
	RSA* rsaPrivKey = PEM_read_bio_RSAPrivateKey(bio, NULL, NULL, NULL);

	if (!rsaPrivKey)
		printf("ERROR: Could not load PRIVATE KEY!  PEM_read_bio_RSAPrivateKey FAILED: %s\n", ERR_error_string(ERR_get_error(), NULL));

	BIO_free(bio);
	return rsaPrivKey;
}

unsigned char* rsaEncrypt(RSA *pubKey, const unsigned char* str, int dataSize, int *resultLen)
{
	int rsaLen = RSA_size(pubKey);
	unsigned char* ed = (unsigned char*)malloc(rsaLen);
	*resultLen = RSA_public_encrypt(dataSize, (const unsigned char*)str, ed, pubKey, PADDING);
	if (*resultLen == -1)
		printf("ERROR: RSA_public_encrypt: %s\n", ERR_error_string(ERR_get_error(), NULL));

	return ed;
}

unsigned char* rsaDecrypt(RSA *privKey, const unsigned char* encryptedData, int *resultLen)
{
	int rsaLen = RSA_size(privKey);

	unsigned char *decryptedBin = (unsigned char*)malloc(rsaLen);
	*resultLen = RSA_private_decrypt(RSA_size(privKey), encryptedData, decryptedBin, privKey, PADDING);
	if (*resultLen == -1)
		printf("ERROR: RSA_private_decrypt: %s\n", ERR_error_string(ERR_get_error(), NULL));

	return decryptedBin;
}

unsigned char* makeAlphaString(int dataSize)
{
	unsigned char* s = (unsigned char*)malloc(dataSize);

	int i;
	for (i = 0; i < dataSize; i++)
		s[i] = 65 + i;
	s[i - 1] = 0;

	return s;
}

char* rsaEncryptThenBase64(RSA *pubKey, unsigned char* binaryData, int binaryDataLen, int *outLen)
{
	int encryptedDataLen;

	unsigned char* encrypted = rsaEncrypt(pubKey, binaryData, binaryDataLen, &encryptedDataLen);

	int asciiBase64EncLen;
	char* asciiBase64Enc = base64(encrypted, encryptedDataLen, &asciiBase64EncLen);

	free(encrypted);


	return asciiBase64Enc;
}

unsigned char* rsaDecryptThisBase64(RSA *privKey, char* base64String, int *outLen)
{
	int encBinLen;
	unsigned char* encBin = unbase64(base64String, (int)strlen(base64String), &encBinLen);


	unsigned char *decryptedBin = rsaDecrypt(privKey, encBin, outLen);
	free(encBin);

	return decryptedBin;
}



int main(int argc, const char* argv[])
{
	ERR_load_crypto_strings();
	
	const char *b64_pKey = "-----BEGIN PUBLIC KEY-----\n"
		"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCp2w+8HUdECo8V5yuKYrWJmUbL\n"
		"tD6nSyVifN543axXvNSFzQfWNOGVkMsCo6W4hpl5eHv1p9Hqdcf/ZYQDWCK726u6\n"
		"hsZA81AblAOOXKaUaxvFC+ZKRJf+MtUGnv0v7CrGoblm1mMC/OQI1JfSsYi68Epn\n"
		"aOLepTZw+GLTnusQgwIDAQAB\n"
		"-----END PUBLIC KEY-----\n";

	const char *b64priv_key = "-----BEGIN RSA PRIVATE KEY-----\n"
		"MIICXAIBAAKBgQCp2w+8HUdECo8V5yuKYrWJmUbLtD6nSyVifN543axXvNSFzQfW\n"
		"NOGVkMsCo6W4hpl5eHv1p9Hqdcf/ZYQDWCK726u6hsZA81AblAOOXKaUaxvFC+ZK\n"
		"RJf+MtUGnv0v7CrGoblm1mMC/OQI1JfSsYi68EpnaOLepTZw+GLTnusQgwIDAQAB\n"
		"AoGBAKDuq3PikblH/9YS11AgwjwC++7ZcltzeZJdGTSPY1El2n6Dip9ML0hUjeSM\n"
		"ROIWtac/nsNcJCnvOnUjK/c3NIAaGJcfRPiH/S0Ga6ROiDfFj2UXAmk/v4wRRUzr\n"
		"5lsA0jgEt5qcq2Xr/JPQVGB4wUgL/yQK0dDhW0EdrJ707e3BAkEA1aIHbmcVfCP8\n"
		"Y/uWuK0lvWxrIWfR5MlHhI8tD9lvkot2kyXiV+jB6/gktwk1QaFsy7dCXn7w03+k\n"
		"xrjEGGN+kQJBAMuKf55lDtU9K2Js3YSStTZAXP+Hz7XpoLxmbWFyGvBx806WjgAD\n"
		"624irwS+0tBxkERbRcisfb2cXmAx8earT9MCQDZuVCpjBWxd1t66qYpgQ29iAmG+\n"
		"jBIY3qn9uOOC6RSTiCCx1FvFqDMxRFmGdRVFxeyZwsVE3qNksF0Zko0MPKECQCEe\n"
		"oDV97DP2iCCz5je0R5hUUM2jo8DOC0GcyR+aGZgWcqjPBrwp5x08t43mHxeb4wW8\n"
		"dFZ6+trnntO4TMxkA9ECQB+yCPgO1zisJWYuD46KISoesYhwHe5C1BQElQgi9bio\n"
		"U39fFo88w1pok23a2CZBEXguSvCvexeB68OggdDXvy0=\n"
		"-----END RSA PRIVATE KEY-----\n";

	int dataSize = 37;
	unsigned char *str = makeAlphaString(dataSize);
	printf("\nThe original data is:\n%s\n\n", (char*)str);


	RSA *pubKey = loadPUBLICKeyFromString(b64_pKey);

	int asciiB64ELen;
	char* asciiB64E = rsaEncryptThenBase64(pubKey, str, dataSize, &asciiB64ELen);

	RSA_free(pubKey);

	printf("Encrypted string:\n%s\n", asciiB64E);

	char* rxOverHTTP = asciiB64E; 

	RSA *privKey = loadPRIVATEKeyFromString(b64priv_key);

	int rBinLen;
	unsigned char* rBin = rsaDecryptThisBase64(privKey, rxOverHTTP, &rBinLen);
	printf("\n\nDecrypted data :\n%.*s\n\n", rBinLen, rBin); 
																							

	RSA_free(privKey);
	free(str);
	free(asciiB64E);  
	free(rBin);
	ERR_free_strings();
}