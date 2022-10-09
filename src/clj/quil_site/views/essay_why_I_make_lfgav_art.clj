(ns quil-site.views.essay-why-I-make-lfgav-art
  (:require [quil-site.views.page :refer [page]]))

(defn essay-why-I-make-lfgav-art-page []
  (page {:tab :essay-why-I-make-lfgav-art
         :type :essay-why-I-make-lfgav-art-page
         :js-files ["https://cdn.jsdelivr.net/npm/p5@1.0.0/lib/p5.js" "js/ab_hash.js" "js/moc-ab-script-compiled-a.js"]
         :title "Why I make long form generative audio visual art"}

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
              [:h2 {} "Why I make long form generative audio visual art"]
              [:p {} "Art and Fear states that art critics typically ask the following 3 questions:"]
              [:ol {}
               [:li {} "What was the artist's goal?"] 
               [:li {} "Did they achieve this goal?"]
               [:li {} "Was it worth doing?"]]
              [:p {} "As author David ... says, it is the third question that is the real clincher."]
              [:p {} "In this essay I lay out my top level goals with audiovisual art and come to some conclusions as to whether these goals are worth achieveing."]
              [:p {} "The middle question of whether I achieve my goal is possibly asked in a different way by critics than I choose to ask of myself as I work on my work. Embracing failure is an inherent goal for me in its own right, easier said than done but an essential habit for taking risks and seeding new ideas! That being said I also value addressing this question objectively for myself as a way to stay true to my intention, including as a way to stay authentic with myself as to how my original goal may have evolved. So while I eshew the black and white assessment of the critic's voice, I do consider in this essay navigation strategies - reliable indicators that allow me feel my way towards my goal for a given project, and around pitfalls."]              
              [:p {} "In definining my goals within the medium of long form generative audiovisual art, I find it is equally important to consider what I am (italic not) trying to achieve, as well what I am.  Likewise when I determine whether my goals are worth pursuing, I remain cognisant of the pitfalls as well as the benefits to my process and to what audiences experience."]
              [:p {} "1. So what makes LFGAVA unique and what are my goals for its unique aspects especially?  Understand Media makes the case that all media contains within it the technologies it extends.  As I follow this line of thinking, what becomes compelling as a goal for my own practice is to work with the affordances specific to of web3 technology.  Here I mean art which pushes the buttons and pulls the levers afforded by web3 technology, creating emergent effects greater than the sum of the audiovisual information technology it encapsulates. My goal is not to work on ideas which would be better expressed using one of the individual embedded technologies, nested like Babushka dolls within web3 technology.  There is a phenomenal body of work by previous artists in the media of paintings, music, film, photography, etc, which I prefer to draw inspiration from as to how they match their ideas so well to their respective medium.  While I subscribe to Kirby Ferguson's idea that everything is a remix, I also like to use my own discretion as to whether I am the one who needs to remix a particular idea using a new medium, and at least to do so mindfully."]
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
              [:img {:class "center", :src "../img/micheal/Micheal.IMMA.Augmented.500x500.jpg", :width "30%"}]
              [:img {:class "hormargins", :src "../img/art/ab/juxt-2.png", :width "30%"}]
              [:img {:class "hormargins", :src "../img/art/ab/juxt-1.png", :width "30%"}]
              [:img {:class "hormargins", :src "../img/art/ab/juxt-3.png", :width "30%"}]
             ]]]]]
        
        ))
