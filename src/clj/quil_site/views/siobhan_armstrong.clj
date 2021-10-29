(ns quil-site.views.siobhan-armstrong
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn siobhan-armstrong-page []
  (page {:tab :siobhan-armstrong
         :type :siobhan-armstrong
         :js-files ["/js/main.js"]
         :title "Siobhán Armstrong"}
        [:div.section
         [:p.lead
          "Siobhán Armstrong"]]

[:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "box"}
     [:div {:class "content"}
      [:div {:class "columns"}
       [:div {:class "column"}

        [:h1 {} [:strong {} "Siobhán Armstrong"]]  
        [:h2 {} "This page is being rebuilt currently. Please check back soon."]        
        [:hr]
        [:p [:em "Early Irish Harp: the State of the Art"] " interview series was funded through the Arts Council Deis Recording and Publication Award 2017"]
        [:p [:img {:class "alignnone " :src "../img/AC_FUND_TradArts.png" :width "221"}]]
        [:hr]]]]]]]))

