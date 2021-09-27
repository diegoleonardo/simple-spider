(ns tags.extractor-test
  (:require [clojure.test :refer [deftest testing is]]
            [matcher-combinators.test :refer [match?]]
            [tags.extractor :as extractor]))

(def img-url "https://www.foo.com")
(def bar-url "https://www.bar.com")
(def foobar-url "https://www.foobar.com")
(def img-tag (str "<img src='" img-url "'/>"))
(def a-tag (str "<a href='" bar-url "'></a>"))
(def div-tag (str "<div><a href='" foobar-url "'></a></div>"))

(def example (str "<!DOCTYPE html>
  <html lang=\"en\">
<head>
  <title>Title of the document</title>
</head>
<body>
<h1>This is a heading</h1>
<p>This is a paragraph.</p>"
                  img-tag
                  a-tag
                  div-tag
                  "</body>"
                  "</html>"))

(def extract-matcher {:assets vector?
                      :links vector?})

(deftest extract
  (testing "Should extract the url attributes in tags correctly"
    (let [result (extractor/extract example)]
      (is (match? extract-matcher
                  result))
      (is (= [img-url]
             (:assets result)))
      (is (= [bar-url foobar-url]
             (:links result)))))
  (testing "Should return empty vectors to assets and links when Html input is the wrong format"
    (doseq [item [nil "" "foobar"]]
      (let [result (extractor/extract item)]
        (is (= []
               (:assets result)))
        (is (= []
               (:links result)))))))
