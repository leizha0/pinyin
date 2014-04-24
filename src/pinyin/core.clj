(ns pinyin.core
  [:require [clojure.java.io :as io]])

(defn load-pinyin-map []
  (with-open [rdr (io/reader (io/resource "pinyin-map"))]
    (into {}
      (map
        (fn [x]
          (let [xs (clojure.string/split x #"\s+")]
            [(ffirst xs) (rest xs)]))
        (line-seq rdr)))))

(def pinyin-map (delay (load-pinyin-map)))

(defn ch->pinyin [x]
  (if-let [py (get @pinyin-map x)]
    (clojure.string/join "|" py)
    x))

(defn phrase->pinyin [xs]
  (map ch->pinyin xs))

