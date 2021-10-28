(ns quil-site.views.simon-chadwick
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn simon-chadwick-page []
  (page {:tab :simon-chadwick
         :type :simon-chadwick
         :js-files ["/js/main.js"]
         :title "Simon Chadwick"}
        [:div.section
         [:p.lead
          "Simon Chadwick"]]

[:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "box"}
     [:div {:class "content"}
      [:div {:class "columns"}
       [:div {:class "column"}

        [:h1 {} [:strong {} "Simon Chadwick"]]  
        
        [:hr]
        [:p [:em "Early Irish Harp: the State of the Art"] " interview series was funded through the Arts Council Deis Recording and Publication Award 2017"]
        [:p [:img {:class "alignnone " :src "../img/AC_FUND_TradArts.png" :width "221"}]]
        [:hr]]]]]]]))

