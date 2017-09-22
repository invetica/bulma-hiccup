(def project 'invetica/bulma-hiccup)
(def version "0.1.0-SNAPSHOT")
(def desc
  "Hiccup-compatible data for building sites with the Bulma CSS framework.")

(set-env!
 :resource-paths #{"resources" "src"}
 :source-paths   #{"test"}
 :dependencies   '[[adzerk/boot-test "RELEASE" :scope "test"]
                   [hiccup "2.0.0-alpha1"]
                   [org.clojure/clojure "1.9.0-beta1" :scope "provided"]])

(task-options!
 repl {:checkouts '[[invetica/html-spec "LATEST"]]}
 pom {:project     project
      :version     version
      :description desc
      :url         "https://github.com/invetica/bulma-hiccup"
      :scm         {:url "https://github.com/yourname/bulma"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[adzerk.boot-test :refer [test]])
