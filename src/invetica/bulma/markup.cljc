(ns invetica.bulma.markup
  (:require [clojure.spec.alpha :as s]))

;; <a>
;; <b>
;; <big>
;; <i>
;; <small>
;; <tt>
;; <abbr>
;; <acronym>
;; <cite>
;; <code>
;; <dfn>
;; <em>
;; <kbd>
;; <strong>
;; <samp>
;; <time>
;; <var>
;; <bdo>
;; <br>
;; <img>
;; <map>
;; <object>
;; <q>
;; <script>
;; <span>
;; <sub>
;; <sup>
;; <button>
;; <input>
;; <label>
;; <select>
;; <textarea>

(s/def :hiccup/inline
  (s/or :str string?
        :block :html/block-element
        :inline :html/inline-element))

;; I don't like the single-word use of "full height" but consitency with Bulma
;; trumps in this library.
(s/def :hero/height
  #{:fullheight :large :medium})

(s/def :hero/subtitle
  :hiccup/inline)

(s/def :hero/title
  :hiccup/inline)

(s/fdef hero
  :args (s/cat :m (s/keys :req-un [:hero/subtitle :hero/title])))

(defn hero
  ([] (hero {}))
  ([{:keys [title subtitle]}]
   [:section.hero
    [:div.container
     (when title
       [:h1.title title])
     (when subtitle
       [:h2.subtitle subtitle])]]))
