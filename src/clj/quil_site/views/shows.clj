(ns quil-site.views.shows
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn shows-page []
  (page {:tab :shows
         :type :shows
         :js-files ["/js/main.js"]
         :title "Shows"}
        [:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "box"}
     [:div {:class "columns"}
      [:div {:class "column"}
       [:div {:class "content"}
        [:h1
         [:strong ""]]
        [:p ""]

        [:h1 [:strong "upcoming shows"]]
        [:p [:strong "18.12.2021"]
         [:br] "Lúthchleasa [lu:hxlˈæsə] concert | Solo performance on harp, voice & electronics | Presented by Galway Arts Centre | Venue: Nun's Island Theatre | Sat 18.12.2021, 19:00 | " [:a {:href "https://www.eventbrite.ie/e/luthchleasa-luhxls-solo-concert-by-micheal-o-cathain-tickets-220844360427"} " Tickets"]]
        [:p [:strong "08.12.2021 – 22.12.2021"]
         [:br] "Lúthchleasa [lu:hxlˈæsə] exhibition | New generative artwork by Mícheál Ó Catháin, showcasing his process of engaging with the early Irish harp tradition on the harp's own terms | Galway Arts Centre, 47 Dominick Street, Galway City | 08.12.2021 - 22.12.2021 |"  [:a {:href "https://www.galwayartscentre.ie/exhibitions/382-luthchleasa-lu-hxl-aes-by-micheal-o-cathain?lang=en"} " Info"]]

        [:h1 [:strong "previous shows"]]
        [:p [:strong "16.10.2021"]
         [:br] "Solo performance on harp & voice | As part of National Harp Day 2021 and supported by Kildare County Council | Presented by Naas Arts & Culture Centre, McAuley Place, Naas"]
        [:p [:strong "09.10.2021 – 16.10.2021"]
         [:br] "Audiovisual installation | Week-long generative art installation featuring early Irish harp, supported by Kildare County Council | Presented by Naas Arts & Culture Centre, McAuley Place, Naas"]
        [:p [:strong "10.01.2020 – 21.02.2020"]
         [:br] "The Uncertainty of History – remembering Eileen Quinn | recorded vocals featured in exhibition by visual artist Bernadette Burns | Galway Arts Centre"]
        [:p [:strong "26.10.2019"]
         [:br] "Solo performance on harp & voice | with Kathleen Loughnane at Achill International Harp Festival 2019 | Féile Chruite Acla 2019, Achill, Co.Mayo |" [:a {:href "http://achillharpfestival.ie"} " Info"]]
        [:p [:strong "19.10.2019"]
         [:br] "Audiovisual installation curated for National Harp Day 2019 | showcasing " [:a {:href "https://michealocathain.com/#interviews"} [:em "Early Irish Harp: the State of the Art"] " interview series"] " | Naas Art & Culture Centre, McAuley Place, Naas"]
        [:p [:strong "04.10.2019"]
         [:br] "Solo performance on harp & voice | with Millie & The Illywhackers and October Fires at The House Presents, Annesley House, North Strand, Dublin 3 |" [:a {:href "http://thehousepresents.wixsite.com/thehousepresents"} " Info"]]
        [:p [:strong "24.11.2019"]
         [:br] "Tunes of O’Hampsey :: solo performance on harp & voice | Primate’s Chapel, Archbishop’s Palace, Armagh"]
        [:p [:strong "20.10.2018"]
         [:br] "Solo performance on harp & voice | with Javier Sáinz at McAuley Place :: Concert and "[:a {:href "https://michealocathain.com/interviews"} "Interview"] " Launch as part of Harp Day 2018 | McAuley Place Arts & Cultural Centre, Naas, Co. Kildare"]
        [:p [:strong "29.08.2018"]
         [:br] "Solo performance on harp & voice | with Ann Heymann at the Fumbally Stables :: Concert and Interview Launch | Fumbally Stables, Dublin 8"]
        [:p [:strong "20.08.2018"]
         [:br] "Launch of "[:a {:href "https://michealocathain.com/interviews"} [:em "Early Irish Harp: the State of the Art"] " interview series"] " | Scoil na gCláirseach Festival of Early Irish Harp | Coláiste Pobail Osraí, Kilkenny | " [:a {:href "https://festival.irishharp.org/"} "Info"]]
        [:p [:strong "17.08.2018"]
         [:br] "Solo performance on harp & voice | with Siobhán Armstrong & Éilís Ní Ríordáin | Scoil na gCláirseach Festival of Early Irish Harp | Coláiste Pobail Osraí, Kilkenny | " [:a {:href "https://festival.irishharp.org/"} "Info"]]







        (comment
          [:p [:strong "10.01.20 – 21.02.20"]
           [:br] "The Uncertainty of History – remembering Eileen Quinn | recorded vocals featured in exhibition by visual artist Bernadette Burns | Galway Arts 
Centre"]
          [:p [:strong "26.10.19"]
           [:br] "Solo performance on harp & voice | with Kathleen Loughnane at Achill International Harp Festival 2019 | Féile Chruite Acla 2019, Achill, Co.Mayo |" [:a {:href "http://achillharpfestival.ie"} " Info"]]
          [:p [:strong "19.10.19"]
           [:br] "Audiovisual installation curated for National Harp Day 2019 | showcasing " [:a {:href "https://michealocathain.com/interviews"} [:em "Early Irish Harp: the State of the Art"] " interview series"] " | Naas Art & Culture Centre, McAuley Place, Naas, Co. Kildare"]
          [:p [:strong "04.10.19"]
           [:br] "Solo performance on harp & voice | with Millie & The Illywhackers and October Fires at The House Presents, Annesley House, North Strand, Dublin 3 |" [:a {:href "http://thehousepresents.wixsite.com/thehousepresents"} " Info"]]
          [:p [:strong "24.11.19"]
           [:br] "Tunes of O’Hampsey :: solo performance on harp & voice | Primate’s Chapel, Archbishop’s Palace, Armagh "]
          [:p [:strong "20.10.18"]
           [:br] "Solo performance on harp & voice | with Javier Sáinz at McAuley Place :: Concert and "[:a {:href "https://michealocathain.com/interviews"} "Interview"] " Launch as part of Harp Day 2018 | McAuley Place Arts & Cultural Centre, Naas, Co. Kildare"]
          [:p [:strong "29.08.18"]
           [:br] "Solo performance on harp & voice | with Ann Heymann at the Fumbally Stables :: Concert and Interview Launch | Fumbally Stables, Dublin 8"]
          [:p [:strong "20.08.18"]
           [:br] "Launch of "[:a {:href "https://michealocathain.com/interviews"} [:em "Early Irish Harp: the State of the Art"] " interview series"] " | Scoil na gCláirseach Festival of Early Irish Harp | Coláiste Pobail Osraí, Kilkenny | " [:a {:href "https://festival.irishharp.org/"} "Info"]]
          [:p [:strong "17.08.18"]
           [:br] "Solo performance on harp & voice | with Siobhán Armstrong & Éilís Ní Ríordáin | Scoil na gCláirseach Festival of Early Irish Harp | Coláiste Pobail Osraí, Kilkenny | " [:a {:href "https://festival.irishharp.org/"} "Info"]])
        ]]]]]]))

