rem do not run without arguments
if "%1" == "" (
	exit /b 1
)

set originalDir=%~dp0
for %%d in ("%originalDir:~0,-1%") do set parentDirectory=%%~dpd

rem run basic uninstall
"%originalDir%uninst.exe" /S

for /f "tokens=4-5 delims=. " %%i in ('ver') do set versionOS=%%i.%%j

if %versionOS% == 5.1 (
	%SYSTEMROOT%\system32\ping.exe localhost -n 10 
)

cd "%SYSTEMROOT%"

rem cleanup remain files
rd /S /Q "%originalDir%" && rd /Q "%parentDirectory%"
