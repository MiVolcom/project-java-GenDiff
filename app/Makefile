.DEFAULT_GOAL := build-run

clean:
	make -C app clean

build:
	make -C app build

install:
	make -C app install

run-dist:
	make -C run-dist

run:
	make -C app run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

update-deps:
	make -C app update-deps

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

