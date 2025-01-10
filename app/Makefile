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
	./build/install/app/bin/app

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run


run-yml:
	./build/install/app/bin/app src/test/resources/fixtures/filepath1.yml src/test/resources/fixtures/filepath2.yml

run-json:
	./build/install/app/bin/app src/test/resources/fixtures/filepath1.json src/test/resources/fixtures/filepath2.json

run-fPlain:
	./build/install/app/bin/app -f plain src/test/resources/fixtures/filepath1.json src/test/resources/fixtures/filepath2.json

run-fJson:
	./build/install/app/bin/app -f json src/test/resources/fixtures/filepath1.json src/test/resources/fixtures/filepath2.json

.PHONY: build

