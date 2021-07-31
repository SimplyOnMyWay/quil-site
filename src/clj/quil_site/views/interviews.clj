(ns quil-site.views.interviews
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn interviews-page []
  (page {:tab :shows
         :type :shows
         :js-files ["/js/main.js"]
         :title "Interviews!"}
        [:div.section
         [:p.lead
          "Interviews"]]

        [:div.section
         [:h3 "Interviews"]
         [:div.row
          [:div.col-md-6.col-xs-12
           [:dl.features
            [:dt "Clojure and ClojureScript"]
            [:dd "Sketches can be run from clojure or in a browser without modifications."]]]
          [:div.col-md-6.col-xs-12
           [:dl.features
            [:dt "Live reloading"]
            [:dd "Modify sketches on fly without closing them."]]]]]))

