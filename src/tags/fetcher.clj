(ns tags.fetcher
  (:require [clj-http.client :as http-client]
            [tags.extractor :as tag-extractor]))

(defn fetch
  "It takes an input URL format (Please, don't forget to inform the protocol :https or :http),
  requests it and return the number of URLs in any a and img tags.

  returning a map with the following format:
    {:assets []
     :links  []}"
  [url]
  (let [{:keys [body]} (http-client/get url)]
    (tag-extractor/extract body)))
