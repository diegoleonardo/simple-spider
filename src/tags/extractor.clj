(ns tags.extractor
  (:require [net.cgrand.enlive-html :as en]))

(def url-pattern #"(?i)^(?:(?:https?|ftp)://)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,}))\.?)(?::\d{2,5})?(?:[/?#]\S*)?$")

(defn url [s]
  (if (nil? s)
    nil
    (re-matches url-pattern s)))

(defn- tag-filtered [html tag attrs]
  (->> (en/select html [tag])
       (map #(get-in % [:attrs attrs]))
       (filterv #(url %))))

(defn a-tag-urls [html]
  (tag-filtered html :a :href))

(defn img-tag-urls [html]
  (tag-filtered html :img :src))

(defn result-body [img-urls a-urls]
  {:assets img-urls
   :links  a-urls})

(defn extract
  "Extracts a (:links) and img (:assets) tag URLs from the HTML string input,
   returning a map with the following format:
    {:assets []
     :links  []}"
  [html]
  (let [parsed-html (en/html-snippet html)
        a-urls (a-tag-urls parsed-html)
        img-urls (img-tag-urls parsed-html)]
    (result-body img-urls a-urls)))
