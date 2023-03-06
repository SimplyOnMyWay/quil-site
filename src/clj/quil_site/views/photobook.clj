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

             [:h2 {} [:strong {} "Content for Mícheál Ó Catháin page in Photobook on Irish Digital Art"]]
               
             [:div {:class "column" :id "as"}
              [:h3 {} [:strong {} "Artist Statement"]]

              (comment
                [:p {} [:img {:class "alignnone ", :src "../img/micheal/MichealOCathain.IMMA.002.Augmented.1000x979.jpg", :width "68%"}]])

              (comment
                [:p "Mícheál is a multimedia artist working primarily with harp & voice performance, computer code, installation. He is a recipient of Irish Arts Council Agility (2021), Traditional Arts Bursary (2017) and Deis Recording & Publication (2017) Awards. Mícheál has performed solo harp & voice concerts at Achill International Harp Festival and Scoil na gCláirseach Festival of Early Irish Harp, and his generative art has been exhibited at Naas Art & Culture Centre and Galway Arts Centre."])

              [:ul
               [:li {} "Music, installation, performance"]
               [:li {} "Engaging with digital archive"]
               [:li {} "Harp"]
               [:li {} "GAC exhib - luthchleasa meaning"]
               [:li {} "What ideas Fearn represenation"]
               [:li {} "Size of Bunting notebook"]]

             [:p "Faithful to historical practices, Mícheál sings with the harp on his left shoulder and employs specialised fingernail techniques (" [:em "lúthchleasa"] ") to shape the resonance of these metal-strung instruments. His arrangements of Bunting manuscript pieces, guided by the rhythms of his " [:em "sean-nós"] " singing, breathe fresh life into Ireland's ancient harp music for contemporary audiences."]
             [:p "Mícheál gravitates equally towards the ancient and the emergent.  He codes custom algorithms to make and share generative audiovisual art which reflects and nourishes his process of engaging with the early Gaelic harp on the harp's own terms."]
             [:p "The word Lúthchleasa (athletics) is cast in this exhibition and concert project in a dual musical role, describing at once the feats of fingers on the metal strings of the early Irish harp or cláirseach, and the idiomatic musical patterns that emerge as a result.  Bridging the ancient and the modern, this body of new generative artwork by Mícheál Ó Catháin showcases his process of engaging with the early Irish harp tradition on the harp's own terms.  For over a decade Mícheál has been discovering the shapes and sounds offered to human touch by the metal and wood of this instrument, and the lúthchleasa patterns encoded in the notes penned by a young Edward Bunting at the 1792 Belfast Harp Meeting."]
             [:p "Interpreting the Bunting manuscripts for a contemporary audience, Mícheál employs computer code as a collaborative partner to represent these patterns in visual form and expresses in this generative art his emotional response to the music. Lúthchleasa [lu:hxlˈæsə] illuminates ancient music and celebrates the beauty and colour spaces inhabited by early Irish art, reimagining for today the full spectrum of expression felt and heard by harpers and listeners alike centuries ago."]

              ]


             [:div {:class "column" :id "ph"}
              [:h3 {} [:strong {} "Photos"]]
              [:br]                                          
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_54.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_54_1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_56.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_56_1000.jpg", :width "20%"}]]
              [:br]
              [:p "(Photographs Accrediation: Photographs by Tom Flanagan, courtesy Galway Arts Centre)"]
              [:br]

              ]
             
             

]]]]]))


