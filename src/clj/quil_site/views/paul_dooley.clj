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
        
        [:hr]
        [:p [:em "Early Irish Harp: the State of the Art"] " interview series was funded through the Arts Council Deis Recording and Publication Award 2017"]
        [:p [:img {:class "alignnone " :src "../img/AC_FUND_TradArts.png" :width "221"}]]
        [:hr]]]]]]]))

