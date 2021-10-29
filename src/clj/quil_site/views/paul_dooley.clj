(ns quil-site.views.paul-dooley
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn paul-dooley-page []
  (page {:tab :paul-dooley
         :type :paul-dooley
         :js-files ["/js/main.js"]
         :title "Paul Dooley"}
        [:div.section
         [:p.lead
          "Paul Dooley"]]

[:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "box"}
     [:div {:class "content"}
      [:div {:class "columns"}
       [:div {:class "column"}

        [:h1 {} [:strong {} "Paul Dooley"]]  

        [:h2 {} "This page is being rebuilt currently. Please check back soon."]
                
        [:hr]


        [:p {} [:em {} "Early Irish Harp: the State of the Art "] "Interview Series was funded through the Arts Council Deis Recording and Publication Award"]
        [:p {} [:img {:class "alignnone ", :src "../img/AC_FUND_TradArts.png" :width "356"}]]
        [:hr]]]]]]]))

