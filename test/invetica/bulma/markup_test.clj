(ns invetica.bulma.markup-test
  (:require
   [clojure.test :refer [deftest is]]
   [hiccup2.core :as hiccup2]
   [invetica.bulma.markup :as sut]))

(defn- seq->html
  [xs]
  (str (hiccup2/html xs)))

(deftest t-hero
  (is (= {} (seq->html (sut/hero)))))
