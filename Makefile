.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

build:
	./gradlew clean build

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
	./app/build/install/app/bin/app app/src/test/resources/filepath1.yml app/src/test/resources/filepath2.yml

run-json:
	./app/build/install/app/bin/app app/src/test/resources/json1.json app/src/test/resources/json2.json

run-fPlain:
	./app/build/install/app/bin/app -f plain app/src/test/resources/json1.json app/src/test/resources/json2.json

run-fJson:
	./app/build/install/app/bin/app -f json app/src/test/resources/json1.json app/src/test/resources/json2.json

.PHONY: build

