@echo off

if "%1"=="" (

	echo ^<Usage^>
	echo 	makejar.bat ^<Package name^> ^<Source file name^>
	
	echo.
	
	echo ^<Options^>
	echo		-jl	Show existing jar files
	echo		-cl	Show existing class files

	goto :end
	
) else if "%1"=="-jl" (

	echo <Existing jar files^>
	dir C:\WORKS\WS\WS_Android\Time_calculator\bin\*.jar
	
	goto :end
	
) else if "%1"=="-cl" (

	echo ^<Class files list^>
	
	for /d %%a in (C:\WORKS\WS\WS_Android\Time_calculator\bin\*) do (
	
		call :hoge "%%a"
		
		dir %%a\*.class
	)
	goto :end

REM	tree C:\WORKS\WS\WS_Android\Time_calculator\bin\ /f
	
REM		goto :end

) else if "%2"=="" (

	echo ^<Usage^>
	echo 	makejar.bat ^<Package name^> ^<Source file name^>

	goto :end

)

:hoge
echo ^<%~1^>
exit /b


REM -------------------------------------
REM		Get trunk
REM -------------------------------------
for /f "delims=." %%a in ("%2") do (
	set trunk=%%a
)

REM -------------------------------------
pushd C:\WORKS\WS\WS_Android\Time_calculator\bin
echo Main-Class: %1.%2 > manifest_%2.txt
echo Manifest file created.
echo Executing: jar cvfm %1_%2.jar manifest_%2.txt %1/%trunk%*.class %1/*.png
jar cvfm %1_%2.jar manifest_%2.txt %1/%trunk%*.class %1/*.png

echo 
echo Processing done. Going back to the root directory.
echo 
cd ..


REM REM ---------------------------------
REM REM No input => Show usage
REM REM ---------------------------------

REM if "%1"=="" (

REM 	echo ^<Usage^>
REM 	echo 	makejar.bat ^<Source file name^>

REM REM 	goto :end
REM )

REM set target_label=%1
REM echo %target_label%

REM :get_base_name

REM for /f "tokens=1-2 delims=\\" %%a in ("%1") do (

REM 	echo %%a
REM 	echo %%b

REM 	if "%%b"=="" (
REM 		echo no
REM 	) else (
REM 		set target_label=%%b
REM 	)
REM REM if %%b=="" (
REM REM 	echo yes
REM REM 	%target_label%=%%a
REM REM ) else (
REM REM 	%target_label%=%%b
REM REM )

REM )

REM echo %target_label%

:end
