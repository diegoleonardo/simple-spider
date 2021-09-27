(ns tags.spider-test
  (:require [clojure.test :refer [deftest testing is]]
            [tags.spider :as spider]))

(def expected "{:assets [], :links [https://www.w3schools.com https://www.w3schools.com/spaces/]}\n")

(deftest ^:integration -main
  (testing "Should return the object in the right form"
    (is (= expected
           (-> "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_basic_document"
               spider/-main
               with-out-str)))))
