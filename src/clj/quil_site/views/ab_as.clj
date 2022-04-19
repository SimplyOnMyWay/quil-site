(ns quil-site.views.ab-as
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]
            [hiccup.page :refer [include-js]]))

;(include-js "https://cdn.jsdelivr.net/npm/p5@1.0.0/lib/p5.js")

(defn ab-as-page []
  (page {:tab :ab-as
         :type :ab-as-page
         :js-files ["https://cdn.jsdelivr.net/npm/p5@1.0.0/lib/p5.js" "js/ab_hash.js" "js/moc-ab-script-compiled-a.js"]
         :title "Art Blocks artist statement"}

        [:div.section
         [:p.lead
          "Art Blocks artist statement: " [:em "Juxt"]]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}

             [:div {:class "column"}
              
              (comment
                [:blockquote
                 [:p "juxt (juxt f)(juxt f g)(juxt f g h)(juxt f g h & fs)"]
                 [:p "Takes a set of functions and returns a fn that is the juxtaposition of those fns.  The returned fn takes a variable number of args, and returns a vector containing the result of applying each fn to the args (left-to-right)."]
                 [:p "((juxt a b c) x) => [(a x) (b x) (c x)]"]
                 [:p "- clojure.core library"]])
              [:blockquote
               [:p "Every cultural period creates art of its own, which can never be repeated again. An effort to revive art-principles of the past, at best, can lead only to the production of stillborn works."]
               [:p "- Wassily Kandinsky" [:em ", On the Spiritual in Art"] " 1910"]]
              [:blockquote
               [:p "The pieces which he [O'Hampsey] delighted to perform were unmixed with modern refinements, which he seemed studiously to avoid; confining himself chiefly to the most antiquated of those strains which have long survived the memory of their composers, and even a knowledge of the ages that produced them. ... When asked to play the very antique tunes, he uniformly replied that there was no use in doing so, they were too hard to learn, they revived painful recollections. In short, he regarded the old music with a superstitious veneration, and thought it, in some sort, a profanation to divulge it to modern ears."]
               [:p "- Edward Bunting, on harper Denis O'Hampsey 1695 - 1807" [:em ", The Ancient Music of Ireland"] " 1840"]]
              [:img {:class "center", :src "../img/micheal/Micheal.IMMA.Augmented.500x500.jpg", :width "30%"}]
              [:br]
              [:p {} [:em [:strong "Juxt"]] " is an audiovisual project for Art Blocks by Mícheál Ó Catháin, inhabiting spaces where early Gaelic musical and visual art interplay.  This interplay is framed by idiomatic features such as tuning modes and ornamentation in musical form, and such as colour palettes and symbols in visual form. The long sonorous ring of the metal-strung Gaelic harp is represented by exponential decays in time and space of parameter values in both forms. Breath and the singing voice are represented by spiral forms and synthesised vocals."]
              [:p {} [:em "Juxt"] " explores the extents of these idiomatic parameters, enquiring whether this ancient idiom can even live and breath when transposed into the long form generative medium. Or whether the resonance of wood, metal strings and human breath remains the essential and exclusive domain of these artforms."]
              [:img {:class "hormargins", :src "../img/art/ab/juxt-2.png", :width "30%"}]
              [:img {:class "hormargins", :src "../img/art/ab/juxt-1.png", :width "30%"}]
              [:img {:class "hormargins", :src "../img/art/ab/juxt-3.png", :width "30%"}]
              [:p {}
               [:br]
               "Curiously contemplating a hypothesis that the answer may be \"both/and\", i.e., digital and carbon-based media juxtaposed symbiotically, the starting point of this project is to ask how the medium of on-chain generative art can help us walk this mountainous soundscape?  What stories can we tell ourelves, our minds nourished and held by this combined musical and visual terrain? Where are the inner gardens lost in time or in obscure archives, which may be remapped with virtual compass, feet and pen extended to us by the generative medium? Where are the borders with something entirely other, the contours beyond which one idiom transitions towards other traditions, real or newly imagined?  And then grounded in this idiomatic terrain using these newly embraced digital senses, and mindful of O'Hampsey's and Kandinsky's resonating admonitions, what new nourishing musical and visual forms may be manifested?"]
              [:p {} [:em "Juxt"] " lives these questions and shares what emerges."]]]]]]]

))


