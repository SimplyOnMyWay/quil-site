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
            [:p {} [:img {:class "alignnone ", :src "../img/micheal/MichealOCathain.IMMA.002.1000x1000.jpg", :width "50%"}]]
             [:p "Mícheál is a multimedia artist working primarily with harp & voice performance, computer code, installation. He is a recipient of Irish Arts Council Agility (2021), Traditional Arts Bursary (2017) and Deis Recording & Publication (2017) Awards. Mícheál has performed solo harp & voice concerts at Achill International Harp Festival and Scoil na gCláirseach Festival of Early Irish Harp, and his generative art has been exhibited at Naas Art & Culture Centre and Galway Arts Centre. Faithful to historical practices, Mícheál sings with the harp on his left shoulder and employs specialised fingernail techniques (lúthchleasa) to shape the resonance of these metal-strung instruments.  "]
             [:p "In addition to his musical and art work, Mícheál maintains an active career in offshore renewables as a chartered" [:a {:href "http://linkedin.com/in/micheal-o-cathain-0956361/"} " marine engineer"] "."]
             ]]]]
))
