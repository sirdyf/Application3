call mvn install:install-file -Dfile=vaadin-server-7.0.4.jar -DgroupId=com.vaadin -DartifactId=vaadin-server -Dversion=7.0.4 -Dpackaging=jar -DgeneratePom=true
call mvn install:install-file -Dfile=vaadin-shared-7.0.4.jar -DgroupId=com.vaadin -DartifactId=vaadin-shared -Dversion=7.0.4 -Dpackaging=jar -DgeneratePom=true
call mvn install:install-file -Dfile=vaadin-client-7.0.4.jar -DgroupId=com.vaadin -DartifactId=vaadin-client -Dversion=7.0.4 -Dpackaging=jar -DgeneratePom=true
call mvn install:install-file -Dfile=vaadin-themes-7.0.4.jar -DgroupId=com.vaadin -DartifactId=vaadin-themes -Dversion=7.0.4 -Dpackaging=jar -DgeneratePom=true
call mvn install:install-file -Dfile=vaadin-theme-compiler-7.0.4.jar -DgroupId=com.vaadin -DartifactId=vaadin-themes-compiler -Dversion=7.0.4 -Dpackaging=jar -DgeneratePom=true
