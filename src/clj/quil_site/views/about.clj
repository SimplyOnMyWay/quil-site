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
           [:h1 {:class "title"}
            "About Mícheál"]
           [:div {:class "content"}
            (comment)
            [:blockquote
             [:p [:span {:style="font-size: small"} [:i "De bhunadh Chill Dara é Mícheál Ó Catháin agus clú bainte amach aige mar dhuine den ghlúin nua a chasann cláirseach."]]]
             [:p [:span {:style="font-size: small"} [:i "From Kildare, Mícheál Ó Catháin has achieved recognition as one of the new generation playing cláirseach."]]] 
             [:p [:span {:style="font-size: medium"} [:b "The Irish Times"]]]]
            [:p "Mícheál Ó Catháin grew up in a musical family in Kildare, immersed in Irish language, singing and music. Performing for decades as a traditional fiddle player and singer, in recent years he has built on these foundations to develop a comprehensive command of the early Irish harp or " [:em "cláirseach"]]
            [:p "Faithful to historical practices, Mícheál sings with the harp on his left shoulder and employs specialised fingernail techniques to shape the resonance of these metal-strung instruments. His arrangements of manuscript pieces, guided by the rhythms of his " [:em "sean-nós"] " singing, breathe fresh life into Ireland’s ancient harp music for contemporary audiences."]
            [:p "Mícheál has performed as a soloist around Ireland in such beautiful venues as the Mussenden Temple in Derry, the Fumbally Stables in Dublin and Naas Arts & Culture Centre in Kildare. He has shared the stage with Cormac Begley, Fiachna Ó Mongáin, Ultan O’Brien, Siobhán Armstrong and Javier Sáinz, as well as with his long-time mentor and collaborator Ann Heymann."]
            [:p "Currently he is working on a debut solo recording, on harp & 
voice, of pieces collected from Denis O’Hampsey, the eldest of the 
harpers to grace the 1792 Belfast Harp Meeting. This recording project 
features an accurate copy of O’Hampsey’s" [:em " Downhill"] " harp, and shares the fruits of " [:a {:href "#projects"} "Mícheál’s 2017/18 Arts Council Traditional Arts Bursary"]]
            [:p "As an open process-forum sharing insights from artists he admires and who influence his musical journey, including some of the leading lights of the early Irish harp, Míchéal posts multimedia" [:a {:href "#interviews"} " interviews"] " on his website."]
                                        ;[:p [:img {:class "aligncenter size-medium"} [:src ""]]]
            [:p "Mícheál’s profile is steadily increasing, as evidenced by his solo harp/vocal performance in June 2017 at Áras an Uachtarán for President
 Michael D Higgins and guests, appearance on Irish language channel TG4 
in November 2017 as part of the inaugural National Harp Day, as 
well as solo performances in 2018 sharing the stage with luminaries of 
the early Irish harp Siobhán Armstrong, Ann Heymann, and Javier Sáinz. A valued member of the wider traditional music community, Mícheál 
performed at the Achill International Harp Festival in 2019."]
            [:p "In parallel to his musical pursuits, Mícheál has long been passionate about offshore renewable energy, and contributes actively in this area as a chartered" [:a {:href "http://linkedin.com/in/micheal-o-cathain-0956361/"} " marine engineer"]]
            [:p "Download Mícheál’s" [:a {:href "https://michealocathain.com/Micheal_EPK.pdf"} " EPK / Electronic Press Kit"]]]]]]
))
