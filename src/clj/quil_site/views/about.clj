(ns quil-site.views.about
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn about-page []
  (page {:tab :about
         :type :about
         :js-files ["/js/main.js"]
         :title "About"}
        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:h2 {:class "content"}
            "About Mícheál"]
           [:div {:class "content"}
            (comment)
            [:blockquote
             [:p [:span {:style="font-size: small"} [:i "De bhunadh Chill Dara é Mícheál Ó Catháin agus clú bainte amach aige mar dhuine den ghlúin nua a chasann cláirseach."]]]
             [:p [:span {:style="font-size: small"} [:i "From Kildare, Mícheál Ó Catháin has achieved recognition as one of the new generation playing cláirseach."]]] 
             [:p [:span {:style="font-size: medium"} [:b "The Irish Times"]]]]
            [:p {} [:img {:class "alignnone ", :src "../img/micheal/MichealOCathain.IMMA.002.Augmented.1000x979.jpg", :width "68%"}]]
             [:p "Mícheál is a multimedia artist working primarily with harp & voice performance, computer code, installation. He is a recipient of Irish Arts Council Agility (2021), Traditional Arts Bursary (2017) and Deis Recording & Publication (2017) Awards. Mícheál has performed solo harp & voice concerts at Achill International Harp Festival and Scoil na gCláirseach Festival of Early Irish Harp, and his generative art has been exhibited at Naas Art & Culture Centre and Galway Arts Centre."]
                         [:p "Faithful to historical practices, Mícheál sings with the harp on his left shoulder and employs specialised fingernail techniques (" [:em "lúthchleasa"] ") to shape the resonance of these metal-strung instruments. His arrangements of Bunting manuscript pieces, guided by the rhythms of his " [:em "sean-nós"] " singing, breathe fresh life into Ireland's ancient harp music for contemporary audiences."]
            [:p "Mícheál gravitates equally towards the ancient and the emergent.  He codes custom algorithms to make and share generative audiovisual art which reflects and nourishes his process of engaging with the early Gaelic harp on the harp's own terms."]
            [:p "In addition to his musical and art work, Mícheál maintains an active career in offshore renewables as a chartered" [:a {:href "http://linkedin.com/in/micheal-o-cathain-0956361/"} " marine engineer"] "."]
             ]]]]
))

