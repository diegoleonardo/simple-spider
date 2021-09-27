(ns tags.spider
  (:require [tags.fetcher :as fetcher])
  (:gen-class))

(defn -main
  [args]
  (let [result (fetcher/fetch args)]
    (println result)))
