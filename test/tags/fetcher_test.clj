(ns tags.fetcher-test
  (:require [clojure.test :refer [deftest testing is]]
            [tags.utils :as utils]
            [tags.fetcher :as fetcher]
            [clj-http.client :as http-client]))

(deftest fetch
  (with-redefs [http-client/get (fn [_]
                                  {:status 200
                                   :body   utils/example})]
    (testing "Should extract the values in correctly way"
      (is (= {:assets ["https://www.foo.com"],
              :links  ["https://www.bar.com" "https://www.foobar.com"]}
             (fetcher/fetch "www.google.com"))))))
