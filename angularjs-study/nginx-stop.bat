rem nginx-stop.bat
set PATH=F:\MyDevelop\nginx-1.14.0;%PATH%
rem %~dp0 is current dir
set BASE_DIR=%~dp0
cd nginx
nginx -s stop -c %BASE_DIR%nginx\nginx.conf
exit