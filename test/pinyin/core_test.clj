(ns pinyin.core-test
  (:require [clojure.test :refer :all]
            [pinyin.core :refer :all]))

(deftest test-phrase
  (is (= '(\a) (phrase->pinyin "a")))
  (is (= '("zan") (phrase->pinyin "赞")))
  (is (= '("zhong|chong|tong") (phrase->pinyin "重")))
  (is (= '("bu|fou" "ming" "jiao|jue" "li") (phrase->pinyin "不明觉厉"))))
