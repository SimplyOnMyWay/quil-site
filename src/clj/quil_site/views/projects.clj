(ns quil-site.views.projects
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn projects-page []
  (page {:tab :projects
         :type :projects
         :js-files ["/js/main.js"]
         :title "Projects"}
        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "columns"}
            [:div {:class "column"}
             [:div {:class "content"}
              [:h2 "Projects"]

              [:hr]

              [:h3 [:strong "Music of O’Hampsey / Ceol Ó hAmsaigh"]]
      [:p "Funded by the Arts Council Traditional Arts Bursary Award, October 2017 to September 2018 saw me further developing and 
refining my harp and voice practice by"
       [:ul
        [:li
         "Historically viable arrangements & performances of ten " [:a {:href "http://harpspectrum.org/historical/heymann_short.shtml"} "Donnchadh Ó hAmsaigh (Denis O'Hampsey)"] " pieces from the 1792 Belfast harp meeting"]
        [:li
         "Exploring innovative ways to arrange and transmit early Irish harp repertoire, drawing on the Irish sean-nós singing tradition"]
        [:li
         "Developing a practice of painting my emotional response to the music. Transposing my expression of the music encoded in the Bunting manuscripts from harp & voice to paint on paper, and back again, has given me growing perspective and freedom in each domain"]
        [:li"Working with " [:a {:href"#interviews"} "Ann Heymann"] " on harp technique, interpretation and arrangement of the Bunting manuscripts"]]]
              [:p {} [:img {:class "alignnone ", :src "../img/micheal/micheal-ann-bursary-workshop-still001a.jpg", :width "640"}]]
              [:p {} [:img {:class "alignnone ", :src "../img/art/Feach.jpg", :width "640"}]]
              [:hr {}]
              [:p "Funding from the Arts Council Traditional Arts Bursary Award is gratefully acknowledged."]
              [:p [:img {:class "alignnone " :src "../img/AC_FUND_TradArts.png" :width "356"}]]



              ]]]]]]))

