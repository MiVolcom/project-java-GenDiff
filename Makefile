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
	make report

lint:
	make -C app lint

update-deps:
	make -C app update-deps


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

