(ns quil-site.views.essay-why-I-combine-IRL-and-digital-voice-and-harp-av
  (:require [quil-site.views.page :refer [page]]))

(defn essay-why-I-combine-IRL-and-digital-voice-and-harp-av-page []
  (page {:tab :essay-why-I-combine-IRL-and-digital-voice-and-harp-av
         :type :essay-why-I-combine-IRL-and-digital-voice-and-harp-av
         :js-files ["https://cdn.jsdelivr.net/npm/p5@1.0.0/lib/p5.js" "js/ab_hash.js" "js/moc-ab-script-compiled-a.js"]
         :title "Why I combine real and IRL voice and harp audiovisuals"}

        [:div.section
         [:p.lead
          (comment          "Why I make generative audio visual art ")]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}

             (comment
               [:a {:href "#intro"} "Introduction"]
               [:br]
               [:a {:href "#s1"} "Section 1...."])
             
             [:div {:class "column" :id "as"}
              [:h2 {} "The benefits to my harp and voice practice of combining both analogue and digital audiovisuals"]
              [:p {} "Intro..."]
              [:p {} "Section 1..."]              
              [:p {} "Benefits:"]
              [:ol
               [:li "..."]
               [:li "..."]]
              [:p {} "Pitfalls:"]
              [:ol
               [:li "..."]
               [:li "..."]]
              [:p {} "Navigational aids:"]
              [:ol
               [:li "..."]
               [:li "..."]]
              
]

             ]]]]]
        
        ))
