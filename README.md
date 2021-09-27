# spider

A simple HTML file tag extractor that was developed using Clojure.

## Installation
First of all, you must have Java and Clojure installed on your machine.

You might follow the installation guide of the languages ([Java](https://www.java.com/en/download/help/index_installing.html) and [Clojure](https://clojure.org/guides/getting_started)).

In my humble opinion, to make life easier, you might use [asdf](https://asdf-vm.com/) to do that.

After that, you can download (or clone) the project.

## Usage

Run the project directly, via `:main-opts` (`-m tags.spider`):

    $ clojure -M:run-m "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_basic_document"
    {:assets [], :links [https://www.w3schools.com https://www.w3schools.com/spaces/]}

Run the project's tests (they'll fail until you edit them):

    $ clojure -M:test:runner

Build an uberjar:

    $ clojure -X:uberjar

This will update the generated `pom.xml` file to keep the dependencies synchronized with
your `deps.edn` file. You can update the version (and SCM tag) information in the `pom.xml` using the
`:version` argument:

    $ clojure -X:uberjar :version '"1.2.3"'

If you don't want the `pom.xml` file in your project, you can remove it, but you will
also need to remove `:sync-pom true` from the `deps.edn` file (in the `:exec-args` for `depstar`).

Run that uberjar:

    $ java -jar spider.jar

## License

Copyright © 2021 Diego_santos

_EPLv1.0 is just the default for projects generated by `clj-new`: you are not_
_required to open source this project, nor are you required to use EPLv1.0!_
_Feel free to remove or change the `LICENSE` file and remove or update this_
_section of the `README.md` file!_

Distributed under the Eclipse Public License version 1.0.
