import concurrent.futures
import socket
import time

class PortScanner:
    def __init__(self, ip, port_range, threads):
        self.__ip = ip
        self.__port_range = port_range
        self.__threads = threads

    def check_ports_async(self):
        self.__startTime = time.time()
        self.__pool = concurrent.futures.ThreadPoolExecutor(self.__threads)
        for x in range(self.__port_range[0], self.__port_range[1]):
            self.__pool.submit(self.__check_port, x)
    
    def scan_time(self):
        self.__pool.shutdown(True)
        print("Scan time: " + time.strftime("%H:%M:%S", time.gmtime(time.time() - self.__startTime)))

    def __check_port(self, port):
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        result = sock.connect_ex((self.__ip, port))
        if result == 0:
            print("Port: %d | OPEN" % port)