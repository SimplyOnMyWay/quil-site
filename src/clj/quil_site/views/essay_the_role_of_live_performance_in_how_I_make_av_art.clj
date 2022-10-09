(ns quil-site.views.essay-the-role-of-live-performance-in-how-I-make-av-art
  (:require [quil-site.views.page :refer [page]]))

(defn essay-the-role-of-live-performance-in-how-I-make-av-art-page []
  (page {:tab :essay-the-role-of-live-performance-in-how-I-make-av-art
         :type :essay-the-role-of-live-performance-in-how-I-make-av-art
         :js-files []
         :title "The role of live performance in how I make audiovisual art"}

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
              [:h2 {} "The role of live performance in how I make audiovisual art"]
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
