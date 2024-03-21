install:
	./gradlew clean install

run-yml:
	./build/install/app/bin/app src/test/resources/filepath1.yml src/test/resources/filepath2.yml

run-json:
	./build/install/app/bin/app src/test/resources/json1.json src/test/resources/json2.json

run-fPlain:
	./build/install/app/bin/app -f plain src/test/resources/json1.json src/test/resources/json2.json

run-fJson:
	./build/install/app/bin/app -f json src/test/resources/json1.json src/test/resources/json2.json

build:
	./gradlew clean build
.PHONY: build

