# disl-hsqldb-sample
Sample project demonstrating basic features of DISL. Gradle is used as build tool.

## Instalation
```
git clone https://github.com/kaja78/disl-hsqldb-sample.git
cd disl-hsqldb-sample/disl-hsqldb-sample
gradle installDist
```

### Configure Eclipse IDE project (optional)
```
gradle eclipse
```

## Play with DISL
```
cd build/install/disl-hsqldb-sample/bin
```
Start lightweight inmemory databse server `startDB.bat`, deploy sample data model using DISL job `deployDB.bat`, load target table using DISL job `loadDB.bat` and finally check data in database `startDbClient.bat`.
