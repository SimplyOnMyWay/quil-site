(ns quil-site.views.javier-sainz
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn javier-sainz-page []
  (page {:tab :javier-sainz
         :type :javier-sainz
         :js-files ["/js/main.js"]
         :title "Javier Sáinz"}
        [:div.section
         [:p.lead
          "Javier Sáinz"]]

[:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "box"}
     [:div {:class "content"}
      [:div {:class "columns"}
       [:div {:class "column"}

        [:h1 {} [:strong {} "Javier Sáinz"]]  
        [:h2 {} "This page is being rebuilt currently. Please check back soon."]
        [:hr]
        [:p [:em "Early Irish Harp: the State of the Art"] " interview series was funded through the Arts Council Deis Recording and Publication Award 2017"]
        [:p [:img {:class "alignnone " :src "../img/AC_FUND_TradArts.png" :width "221"}]]
        [:hr]]]]]]]))

