(ns quil-site.views.interviews
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn interviews-page []
  (page {:tab :interviews
         :type :interviews
         :js-files ["/js/main.js"]
         :title "Interviews"}
        [:div.section
         [:p.lead
          "Interviews"]]

[:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "box"}
     [:div {:class "content"}
      [:div {:class "columns"}
       [:div {:class "column"}
        [:h1 [:strong [:em "Early Irish Harp : the State of the Art"] " interview series"]]
        [:h2 "A unique series of interviews with prominent players of the early Irish harp Siobhán Armstrong, Simon Chadwick, Paul Dooley, Ann Heymann and Javier Sáinz."]
        [:h3 "In a long-form interview format combining words, photos and film, Mícheál Ó Catháin learns from each artist – stories from their formative musical experiences, insights into manuscript & early printed sources, and how to demystify the most important features of playable replica instruments."]
        [:h3 "A rich diversity of opinions and approaches is celebrated, through the playing of a common piece by each artist – the " [:em "Jointure & Jigg"] " a version of which is found in both the Bunting and Neal collections – alongside other pieces which they have chosen from their journeys through this fascinating ancient tradition."]
        [:hr]
        [:p [:em "Early Irish Harp: the State of the Art"] " interview series was funded through the Arts Council Deis Recording and Publication Award 2017"]
        [:p [:img {:class "alignnone " :src "img/AC_FUND_TradArts.png" :width "221" :height "73"}]]
        [:hr]
        [:h2 [:strong "Ann Heymann"]]
        [:p [:iframe {:src "https://player.vimeo.com/video/335613770" :allowfullscreen "allowfullscreen" :width "640" :height "360" :frameborder "0"}]]
        [:blockquote
         [:p "It’s fun making music out of tea-leaves! It’s not like that, I’m joking – we have the harp, and as I often say we have hands not claws, and honey still tastes sweet. What I mean by that is that people like to emphasise the differences between times past and our modern times, but for me the early Irish harp can still speak to us with a relevance similar to that which it had for our ancestors."]
         [:p "- Ann Heymann"]]
        [:h3 {} [:strong [:a {:href "https://michealocathain.com/interviews/ann-heymann-1"} "Part 1 of " [:em {} "Early Irish Harp: the State of the Art"] " interview with Ann Heymann here"]]]
        [:h3 {} [:strong [:a {:href "https://michealocathain.com/interviews/ann-heymann-2"} "Part 2 of " [:em {} "Early Irish Harp: the State of the Art"] " interview with Ann Heymann here"]]]
        [:hr]
        [:h2 [:strong "Paul Dooley"]]
        [:p [:iframe {:src "https://player.vimeo.com/video/335579010" :allowfullscreen "allowfullscreen" :width "640" :height "360" :frameborder "0"}]]
        [:blockquote
         [:p "I wasn’t really interested in the the old harpers and all that kind of stuff – 17th century and 18th century, medieval and what have you. Only as I went on I discovered more about it and then became interested. But in my younger days jigs and reels were all I was after really!"]
         [:p "- Paul Dooley"]]
        [:h3 {} [:strong [:a {:href "https://michealocathain.com/interviews/paul-dooley"} "Full " [:em "Early Irish Harp: the State of the Art"] " interview with Paul Dooley here"]]]
        [:hr]
        [:h2 [:strong "Javier Sáinz"]]
        ;[:br]
        [:p [:iframe {:src "https://player.vimeo.com/video/335605591" :allowfullscreen "allowfullscreen" :width "640" :height "360" :frameborder "0"}]]
        [:blockquote
         [:p
          "The early Irish harp is within a musical tradition that has never been completely cut. The proof for this is that the original early Irish harp music doesn’t sound ‘old’ to modern ears, in the way that lute music does for example. So it makes sense to start creating new music for the early Irish harp. To me it would not be something artificial – as long as you have all the knowledge and background."]
         [:p "- Javier Sáinz"]]
        [:h3 [:strong [:a {:href "https://michealocathain.com/interviews/javier-sainz"} "Full " [:em "Early Irish Harp: the State of the Art"] " interview with Jaiver Sáinz here"]]]
        [:hr]
        [:h2 [:strong "Simon Chadwick"]]
        [:p [:iframe {:src "https://player.vimeo.com/video/308823584" :allowfullscreen "allowfullscreen" :width "640" :height "360" :frameborder "0"}]]
        [:blockquote
         [:p "Another way of looking at it is the continuing stream of this tradition starting in the mists of ancient times and coming right through to to the last of the tradition bearers in the 19th century. I’m interested in working backwards. The later you get the more evidence there is, obviously. So you start right at the end where there is loads of stuff and you gradually work your way back. Then by the time you go back early enough such that there is no evidence, you’ve got a whole body of feeling for the tradition."]
         [:p "- Simon Chadwick"]]
        [:h3 [:strong [:a {:href "https://michealocathain.com/interviews/simon-chadwick"} "Full "[:em "Early Irish Harp: the State of the Art"] " interview with Simon Chadwick here"]]]
        [:hr]
        [:h2 [:strong "Siobhán Armstrong"]]
        [:p [:iframe {:src "https://player.vimeo.com/video/329340097" :allowfullscreen "allowfullscreen" :width 640 :height 360 :frameborder 0}]]
        [:blockquote
         [:p "So eventually the penny dropped and I thought ‘but we’ve got our own early harp in Ireland’! I’m quite a slow person, you know – it takes quite a while for the the penny to drop with me! I thought ‘I’m playing the Spanish early harp and the Italian one and the European medieval one, but what about my own early harp?’ And once that penny dropped my whole life changed. That was it – I basically haven’t stopped running since."]
         [:p "- Siobhán Armstrong"]]
        [:h3 [:strong [:a {:href "https://michealocathain.com/interviews/siobhan-armstrong"} "Full "[:em "Early Irish Harp: the State of the Art"] " interview with Siobhán Armstrong here"]]]
        [:hr]
        [:p [:em "Early Irish Harp: the State of the Art"] " interview series was funded through the Arts Council Deis Recording and Publication Award 2017"]
        [:p [:img {:class "alignnone " :src "img/AC_FUND_TradArts.png" :width "221"}]]
        [:hr]]]]]]]))

