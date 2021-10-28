(ns quil-site.views.home
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn home-page []
  (page {:tab :home
         :type :home
         :js-files ["/js/main.js"]
         :title "Homepage of Mícheál Ó Catháin"}
        [:div.section
         [:p.lead
          ""]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}
             [:div {:class "column"}
              [:img {:class "alignnone ", :src "../img/micheal/MichealFumballyAug2018.jpg", :width "640"}]]]
            ]]]]
))
