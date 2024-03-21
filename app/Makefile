.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run


run-yml:
	./build/install/app/bin/app src/test/resources/filepath1.yml src/test/resources/filepath2.yml

run-json:
	./build/install/app/bin/app src/test/resources/json1.json src/test/resources/json2.json

run-fPlain:
	./build/install/app/bin/app -f plain src/test/resources/json1.json src/test/resources/json2.json

run-fJson:
	./build/install/app/bin/app -f json src/test/resources/json1.json src/test/resources/json2.json

.PHONY: build

