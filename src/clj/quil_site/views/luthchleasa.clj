(ns quil-site.views.luthchleasa
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn luthchleasa-page []
  (page {:tab :luthchleasa
         :type :luthchleasa-page
         :js-files ["/js/main.js"]
         :title "Lúthchleasa Showcase"}

        [:div.section
         [:p.lead
          "Lúthchleasa Showcase"]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content" :style "background-color:hsl(200,90%,100%);"}
            [:div {:class "columns"}

             [:div {:class "column"}
              [:h3 {} [:strong {} "Beith Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/beith-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/beith-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Barrlúth"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm (unframed)" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P (unframed)"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/beith-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/beith-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Barrlúth oscailte II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/beith-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/beith-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Barrlúth oscailte I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]

              [:h3 {} [:strong {} "Coll Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/coll-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/coll-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Cúl aithris I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/coll-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/coll-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Caslúth"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/coll-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/coll-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Cúl aithris II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]

              [:h3 {} [:strong {} "Fearn Series"]]
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
               [:a {:href "../img/art/luthchleasa/fearn-01-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-02-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-03-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leath leagadh I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-04-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-04-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-05-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-05-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leath leagagh II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-06-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-06-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh I"]]
                [:span {:style "font-size:9px"} [:br] "141x121m" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-07-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-07-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]

              [:br]
              [:br]
              
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-08-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-08-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Crothach aon mhéar I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-09-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-09-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas IV"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-10-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-10-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-11-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-11-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh IV"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-12-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-12-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leath leagadh III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-13-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-13-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Crothach aon mhéar II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-14-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-14-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh V"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-15-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-15-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh VI"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]              
              
              
              [:h3 {} [:strong {} "Luis Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Taobhchrobh"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Ceann an chruibh I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Lánchrobh"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:br]
              [:br]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-04-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-04-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Ceann an chruibh II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-05-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-05-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Glaslúth"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]              
              [:h3 {} [:strong {} "Sail Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth beag I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth beag II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]                        [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Suas éirí"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:br]
              [:br]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-04-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-04-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth mór suas"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-05-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-05-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth mór síos"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€390 + P&P"]]]

              [:br]
              [:br]

              ]]]]]]))


