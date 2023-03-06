(ns quil-site.views.photobook
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn photobook-page []
  (page {:tab :photobook
         :type :photobook-page
         :js-files [""]
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
               [:li {} "GAC exhib - luthchleas"]
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

             [:div {:class "column" :id "hi-res"}
              [:h3 {} "Fearn generative art"]


              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with straight edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:p {} "The prints for the Fearn series have dimensions 141 x 121 mm, identical to the paper Bunting used in his field collecting of the old music from Irish harpers in the period 1792 - ca. 1805."]
              [:p {} "Four " [:em "lúthchleasa"] " are represented in the Fearn series:"]
              [:ul
               [:li {} [:em "Leagadh anuas"] " , translated from Gaelic to English as \"falling/knocked down from above\". Four prints."]
               [:li {} [:em "Leath leagadh"] " , translated as \"half-falling\". Three prints."]
               [:li {} [:em "Brisidh"] " , translated as 'a break'. Six prints"]
               [:li {} [:em "Crothach aon mhéar"] " , translated as 'one finger shaking'. Two prints"]]
              [:br]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-01--20211123T233014518-seed-3780__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;height:80px"}
                [:span {:style "font-size:12px"} [:em "Leagadh anuas I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-02--20211123T231136929-seed-5870__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Leagadh anuas II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-03--20211123T231205258-seed-8610__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Leath leagadh I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-05--20211123T23363162-seed-6280__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-04-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Leagadh anuas III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-05--20211123T23363162-seed-6280__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-05-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Leath leagadh II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-06--20211123T231211510-seed-3310__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-06-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Brisidh I"]]
                [:span {:style "font-size:9px"} [:br] "141x121m" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-07--20211123T231219592-seed-3100__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-07-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Brisidh II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]

              [:br]
              [:br]
              
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-08--20211123T231328490-seed-3760__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-08-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Crothach aon mhéar I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-09--20211123T231400875-seed-10__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-09-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Leagadh anuas IV"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-10--20211123T231410615-seed-2830__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-10-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Brisidh III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-11--20211123T23115222-seed-7440__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-11-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Brisidh IV"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-12--20211123T231423670-seed-6590__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-12-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Leath leagadh III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-13--20211123T231442414-seed-7370__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-13-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Crothach aon mhéar II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-14--20211123T231508849-seed-8750__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-14-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh V"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-15--20211123T233753372-seed-3610__5640x4840_GAC-FINAL.tif"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-15-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh VI"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]              
              [:br]
              [:br]


              
              
              ]
             
             ]]]]]
        ))


