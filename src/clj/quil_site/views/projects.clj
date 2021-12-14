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
              [:h3 [:strong "Lúthchleasa [lu:hxlˈæsə]"]]
              [:p {} [:img {:class "alignnone ", :src "../img/art/luthchleasa/coll-01-1000x1000.jpg", :width "33%"}]
               [:img {:class "alignnone ", :src "../img/art/luthchleasa/coll-02-1000x1000.jpg", :width "33%"}]
               [:img {:class "alignnone ", :src "../img/art/luthchleasa/coll-03-1000x1000.jpg", :width "33%"}]]
              [:p "The word Lúthchleasa (athletics) is cast in this exhibition and concert project in a dual musical role, describing at once the feats of fingers on the metal strings of the early Irish harp or cláirseach, and the idiomatic musical patterns that result. Bridging the ancient and the modern, this exhibition of new generative artwork by Mícheál Ó Catháin showcases his process of engaging with the early Irish harp tradition on the harp's own terms.  For over a decade Mícheál has been discovering the shapes and sounds offered to human touch by the metal and wood of this instrument, and the lúthchleasa patterns encoded in the notes penned by a young Edward Bunting at the 1792 Belfast Harp Meeting. Interpreting the Bunting manuscripts for a contemporary audience, Mícheál employs computer code as a collaborative partner to represent these patterns in visual form and expresses in this generative art his emotional response to the music. Lúthchleasa [lu:hxlˈæsə] illuminates ancient music and celebrates the beauty and colour spaces inhabited by early Irish art, reimagining for today the full spectrum of expression felt and heard by harpers and listeners alike centuries ago."]
              [:p "Funding from the Arts Council Traditional Arts Agility Award is gratefully acknowledged."]
              [:p [:img {:class "alignnone " :src "../img/AC_FUND_TradArts.png" :width "15%"}]]
              
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
              [:p {} [:img {:class "alignnone ", :src "../img/micheal/micheal-ann-bursary-workshop-still001a.jpg", :width "49%"}] " "
               [:img {:class "alignnone ", :src "../img/art/Feach.jpg", :width "49.5%"}]]
              [:p "Funding from the Arts Council Traditional Arts Bursary Award is gratefully acknowledged."]
              [:p [:img {:class "alignnone " :src "../img/AC_FUND_TradArts.png" :width "15%"}]]
              ]]]]]]))

