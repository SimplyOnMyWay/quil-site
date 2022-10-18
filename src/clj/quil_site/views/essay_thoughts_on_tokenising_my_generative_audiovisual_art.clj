
(ns quil-site.views.essay-thoughts-on-tokenising-my-generative-audiovisual-art
  (:require [quil-site.views.page :refer [page]]))

(defn essay-thoughts-on-tokenising-my-generative-audiovisual-art-page []
  (page {:tab :essay-thoughts-on-tokenising-my-generative-audiovisual-art
         :type :essay-thoughts-on-tokenising-my-generative-audiovisual-art
         :js-files []
         :title "Thoughts on tokenising my generative audiovisual art"}
        [:div.section
         [:section {:class "section"}
          [:div {:class "container"}
           [:div {:class "box"}
            [:div {:class "content"}
             [:div {:class "columns"}
              [:div {:class "column" :id "as"}
               [:h2 {} "Thoughts on tokenising my generative audiovisual art"]
               [:img {:class "hormargins", :src "../img/art/ab/juxt-11-10-2022-1.png", :width "50%"}]

               [:p {} "October 2022"]
               [:br]
               [:p {} "Here is the breakdown of price for prints I made for my first solo exhibition Lúthchleasa, and subsequently framed"]
               [:ol
                [:li "€200: fine-art printing, including cost of Hahnemuhle archival paper"]
                [:li "€150: my time and creative input"
                [:li "€340: oak framing with archival glass"]
                [:li "€100: signing, cert of authenticity, code print out (value of provenance of physical artwork)"]                                 ]]
               [:p {} "With this physical art work, only the second item, my time and creative input, could reasonably be expected to increase significantly as my career progresses.  Or more specifically, as I both gain increased exposure and demand for my art work increases.  Regardless, once I first sell the physical artwork, I get no further income from onward sales"]
               [:p {} "All this is fairly typical the traditional model for making and sellign visual art.  Now I consider, for my own case, the new emerging model of NFT's against and/or complementing this traditional model. Three scenarios come to mind"]
               [:ol
                [:li "Traditional (IRL) exhibition of my generative artwork, such as at Galway Art Centre in December 2021, with the addition of an NFT, with 10% royalty smart contract, being added at cost (assuming Tezos network) of circa €10"]
                [:li "Online-only exhibition, with NFT priced to reflect cost items 2 above, i.e., my time and creative input"]
                [:li "Online exhibition, as per immediatly previous, but with additional option (at extra cost) should collector wish me to print and sign the piece.  Assumes shipping with frame/glass not practical"]]
               [:p {} "In scenarios 2 and 3, the NFT does a kind of inversion in the order of priority in the pricing structure of my work.  With NFTs, my time and creative input is valued as a necessary and fundamental element of what a collector pays.  Printing and framing are ommitted in scenario 2 and optional in scenario 3.  In all scenarios the NFT creates an entirely new mechanism (compared to traditional art) of royalties going back to the artist each time the work is resold"]
               [:p {} "Choices that arise for me include:"]
               [:ol
                [:li "How to price the NFT into the price of a piece exhibited on paper/frame in a gallery. It feels like this should be a nominal cost - the price of my time and artistic input is already baked in, €150 for my GAC exhibition, and presumably increasing as my 'traditional' track-record increases.  Or perhaps the NFT gives something important and valuable to the collector, digital ownership, which is referanced in the physical certificate of authenticity"]
                [:li {} "Do I allow collectors hold onto the physical artwork, after they sell the NFT.  I think so - this would be a benefit of being the first buyer."]
                [:li {} "Do I sign, provide certs of authenticity for later buyers of my work?  Nice problem to have!  I think I don't benefit from this, nor do they - the NFT massively supercedes traditional provenance value of a signature etc.  It would be interesting if I could benefit from a higher price paid by the new collector to the original to include the signed work - in a way I have to get this if it is in the royalty!  Off chain selling of the physical signed orignal could be a problem... not really in my control. A variant could be multiple edition mints of a piece, each which I could sign.  For 1 of 1's it feels like I would only sign the first print.  It's fascinating to think of the theoretical infinite prints which could be done by non-NFT holders, which they could then frame and would have the value of the materials..... "]]
               [:p {} "With increased exposure and demand, a massive benefit of the online space, I anticipate the value associated with provinance (i.e., that it is my creative input, linked publically, immutably to the owner), will begin to dwarf the value of printing/framing and even signing.  I find it a helpful thought experiment to consider how I would set up the online collection of Luthchleasa if I knew:"]
               [:ol
                [:li "collectors would buy the NFT for at least €5000"]
                [:li "every collector would pay for the additional option of signed framed prints, at €500"]]
               [:br]
               [:p {} "Next...  which blockchain network (Tezos, but also open to Eth if now more environmentally friendly, also Solana for speed), NFT marketplaces ... network dependent but for Tezos Objkt seems the obvious choice, though perhaps fx-hash if I do allow minters to generate the art (once I fix bugs!!!) -- may limit set size, but perhaps no bad thing, digital marketing strategy, online galleries to recommend to owners..., working with IRL galleries to avail of their legitimising my art and for their marketing reach... "]]]]]]]])) 
  
