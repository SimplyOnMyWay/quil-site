(ns quil-site.views.shows
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn shows-page []
  (page {:tab :shows
         :type :shows
         :js-files ["/js/main.js"]
         :title "Shows!"}
        [:div.section
         [:p.lead
          "Shows"]]

        [:div.section
         [:h3 "Shows"]
         [:div.row
          [:div.col-md-6.col-xs-12
           [:dl.features
            [:dt "Clojure and ClojureScript"]
            [:dd "Sketches can be run from clojure or in a browser without modifications."]]]
          [:div.col-md-6.col-xs-12
           [:dl.features
            [:dt "Live reloading"]
            [:dd "Modify sketches on fly without closing them."]]]]]))

