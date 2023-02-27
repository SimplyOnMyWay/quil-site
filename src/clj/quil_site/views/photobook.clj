(ns quil-site.views.photobook
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn photobook-page []
  (page {:tab :photobook
         :type :photobook-page
         :js-files ["/js/main.js"]
         :title "Photobook on Irish Digital Art - Mícheál Ó Catháin"}

        [:div.section
         [:p.lead
          ""]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}

             [:h2 {} [:strong {} "Video and photo documentation of "]]
             [:h2 {} [:strong {} "Lúthchleasa [lu:hxlˈæsə]"]]
             [:h2 {} [:strong {} "@ Galway Arts Centre / December 2021"]]
             ;; toc at top of page with links to sections...

             [:div {:class "column" :id "vi"}
              [:h3 {} [:strong {} "Artist Statement"]]
              ]
]]]]]))


