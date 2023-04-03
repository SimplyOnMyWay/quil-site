(ns quil-site.views.photobook
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn photobook-page []
  (page {:tab :photobook
         :type :photobook-page
         :js-files [""]
         :title "Photobook on Irish Digital Art - Mícheál Ó Catháin"}

        [:div.section
         [:p.lead
          ""]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}
             [:h2 {} [:strong {} "Content for Mícheál Ó Catháin page in Photobook on Irish Digital Art"]]

             [:div {:class "column" :id "ph"}
              [:h3 {} [:strong {} "Title and date of the piece featured in the specified image, as well as any contextual information that might be relevant ... exhibition inclusions, funding acknowledgements etc:"]]
              [:h3 {} "Click on each image to download high resolution TIF file."]
              [:br]
              [:p {}
               [:strong {}"Exhibition Title:"]
               [:br] "\"Lúthchleasa [lu:hxlˈæsə]\""]
              [:p {}
               [:strong "Exhibition inclusions:"]
               [:br] "Galway Arts Centre, solo exhibition titled \"Lúthchleasa [lu:hxlˈæsə]\", December 2021"
               [:br] "Lord Mayor's Pavillion Cork, group exhibition titled \"Data | Art\", June 2023"]

              [:p
               [:strong "Funding acknowledgement: "]
               [:br "Arts Council Agility Award 2021"]]
              [:br]
              [:br]

              [:hr]
              [:br]

              [:h4 {} [:b "Beith Series"]]
              [:a {:href "../img/art/luthchleasa_documentation/beith-20230328T162036404-seed-140-10800x10800px.tif"} [:img {:class "centerBorder", :src "../img/art/luthchleasa_documentation/scaled/beith-140-1000x1000.jpg", :width "50%"}]]
              [:br]
              [:p {}
               [:strong "Title of artwork: "]
               [:br] "Barrlúth oscailte II"]
              [:p {}
               [:strong "Year"]
               [:br] "2021"]
              [:p {}
               [:strong "Title of algorithm/series from which the artwork is taken: "]
               [:br] "Beith"]
              [:p
               [:strong "Scan to view and collect work from the full Beith series online:"]
               [:br]]
              [:a {:href "../img/art/luthchleasa_documentation/qr-code-beith.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-beith.png", :width "10%"}]]
              [:br]
              [:p
               [:strong "Immutable address of the Beith series on the Tezos blockchain:"]
               [:br] "KT19GgvFszeTctuf9z1f8TJ1bpNcM532MJN8"]

              
              [:hr]
              [:br]

              [:h4 {} [:b "Coll Series"]]
              [:a {:href "../img/art/luthchleasa_documentation/coll-20230328T170814857-seed-800-7800x7800px.tif"} [:img {:class "centerBorder", :src "../img/art/luthchleasa_documentation/scaled/coll-800-1000x1000.jpg", :width "50%"}]]
              [:br]
              [:p {}
               [:strong "Title of artwork: "]
               [:br] "Caslúth II"]
              [:p {}
               [:strong "Year"]
               [:br] "2021"]
              [:p {}
               [:strong "Title of algorithm/series from which the artwork is taken: "]
               [:br] "Coll"]
              [:p
               [:strong "Scan to view and collect work from the full Coll series online:"]
               [:br]]
              [:a {:href "../img/art/luthchleasa_documentation/qr-code-coll.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-coll.png", :width "10%"}]]
              [:br]
              [:p
               [:strong "Immutable address of the Coll series on the Tezos blockchain:"]
               [:br] "KT1AHckTQA4MwzgMHNhnQCXGXv2i3zLA5WsU"]

              [:hr]              
              [:br]

              [:h4 {} [:b "Fearn Series"]]
              [:a {:href "../img/art/luthchleasa_documentation/fearn-20211212T191500586-seed-10560-2517x2160px.tif"} [:img {:class "centerBorder", :src "../img/art/luthchleasa_documentation/scaled/fearn-10560-1000x1000.jpg", :width "50%"}]]
              [:br]              
              [:p [:strong "Title of artwork: "] "Leath leagadh IV" ]
              [:p {}
               [:strong "Year"]
               [:br] "2021"]              
              [:p {}
               [:strong "Title of algorithm/series from which the artwork is taken: "]
               [:br] "Fearn"]

              [:br]
              
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_54.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_54_1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_56.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_56_1000.jpg", :width "20%"}]]
              [:p
               [:strong "Accreditation: "]
               [:br] "Photographs by Tom Flanagan, courtesy Galway Arts Centre"]
              [:p
               [:strong "Titles of individual artworks shown in the photographs: "]
               [:br] "(top to bottom) Leagadh anuas I, Leagadh anuas II, Leath leagadh I, Leagadh anuas III, Leath leagadh II, Brisidh I, Brisidh II"]
                            [:p
               [:strong "Scan to view and collect work from the full Fearn series online:"]
               [:br]]
              [:a {:href "../img/art/luthchleasa_documentation/qr-fearn-coll.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-fearn.png", :width "10%"}]]
              [:br]
              [:p
               [:strong "Immutable address of the Fearn series on the Tezos blockchain:"]
               [:br] "KT1Wzm9am9PdA8skihrAG4mUyjD12nJr2BSH"]

              [:hr]              
              [:br]

              [:h4 {} [:b "Luis Series"]]
              [:a {:href "luis-20230328T16444447-seed-4160-7800x7800px.tif"} [:img {:class "centerBorder", :src "../img/art/luthchleasa_documentation/scaled/luis-4160-1000x1000.jpg", :width "50%"}]]
              [:br]              
              [:p
               [:strong "Title of artwork: "]
               [:br] "Malairt phonch"]
              [:p {}
               [:strong "Year"]
               [:br] "2021"]              
              [:p {}
               [:strong "Title of algorithm/series from which the artwork is taken: "]
               [:br] "Luis"]
                            [:p
               [:strong "Scan to view and collect work from the full Luis series online:"]
               [:br]]
              [:a {:href "../img/art/luthchleasa_documentation/qr-code-luis.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-luis.png", :width "10%"}]]
              [:br]
              [:p
               [:strong "Immutable address of the Luis series on the Tezos blockchain:"]
               [:br] "KT1AsAYNXLLfC5cc7oK8ZE8GWBcofFrk5Uvv"]

              [:hr]
              [:br]

              [:h4 {} [:b "Sail Series"]]
              [:a {:href "../img/art/luthchleasa_documentation/sail-05--20211123T100906460-seed-7760__10800x10800_GAC-FINAL.tif"} [:img {:class "centerBorder", :src "../img/art/luthchleasa_documentation/scaled/sail-7760-1000x1000.jpg", :width "50%"}]]
              [:br]              
              [:p
               [:strong "Title of artwork: "]
               [:br] "Sruth mór síos"]
              [:p {}
               [:strong "Year"]
               [:br] "2021"]
              [:p {}
               [:strong "Title of algorithm/series from which the artwork is taken: "]
               [:br] "Sail"]
              [:p
               [:strong "Scan to view and collect work from the full Sail series online:"]
               [:br]]
              [:a {:href "../img/art/luthchleasa_documentation/qr-code-sail.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-sail.png", :width "10%"}]]
              [:br]
              [:p
               [:strong "Immutable address of the Sail series on the Tezos blockchain:"]
               [:br] "KT1RNut3HpiGeCbfQ9jezo9Ha7b42tmnWqDf"]

              [:hr]
              [:br]
              [:br]

              (comment
                [:p
                 [:br] "."
                 [:br] "."               
                 [:br] "[Image showing guy sitting on bench on front of 3 of the 5 AV screens?]"
                 [:br] "."
                 [:br] "."])
              
              [:br]
              [:br]]

             
             [:div {:class "column" :id "as"}
              [:h3 {} [:strong {} "A 200-300 word description of what is featured in each image, so that they are contextualised for readers"]]
              [:p "The images shown are taken from an exhibition of generative art by multimedia artist Mícheál Ó Catháin, titled \"Lúthchleasa [lu:hxlˈæsə]\". The show combines digital archival prints, audiovisual installation and live solo performance on early Gaelic harp, voice and electronics. It represents Mícheál's emotional response to the music encoded in the Bunting manuscripts, a collection of early Gaelic harp tunes (many with associated Irish-language song texts) hand-notated on paper in real-time from the playing of the old harpers in the period 1792 - c. 1805."]
              [:p "Mícheál's process for his \"Lúthchleasa [lu:hxlˈæsə]\" collection involved him coding five custom computer algorithms, each capable of generating an infinite number of unique digital images.  Mícheál generated about two thousand images from each of the algorithms. He then curated a series of approximately one hundred images from each of these five sets. During a last curation step he selected a shortlist of sixteen images from his Beith, Coll, Luis and Sail algorithms for fine-art printing on 40 x 40 cm archival paper. He also selected fifteen images from his Fearn algorithm for smaller 14 x 12 cm prints, in homage to the dimensions of the collecting field paper of Edward Bunting.  For Mícheál's exhibition in Galway Arts Centre, the medium format prints were wall-mounted, while the smaller pieces from the Fearn series were exhibited flat on two glass-topped display tables. In an adjacent space the full set of curated images (numbering about five hundred in all), along with generative audio also coded by Mícheál, were fed by Raspberry Pi mini-computers to five Samsung Crystal 43inch displays & speakers."]
              [:p "Selected works from each of Mícheál's Beith, Coll, Fearn, Luis and Sail series are shown. The photograph shows seven Fearn series prints, laid on a display table at Galway Arts Centre. "]
              
              ]
              
             [:div {:class "column" :id "bio"}
              [:h3 {} [:strong {} "A 300-500 word biographical note (written in the third person)"]]
               [:p "Mícheál Ó Catháin is a multimedia artist working primarily with performance (early Gaelic harp and voice), computer code, installation. Faithful to historical practices, Mícheál sings with the harp on his left shoulder and employs specialised fingernail techniques (which he has coined \"lúthchleasa\") to shape the resonance of these metal-strung instruments. His decades-long grounding in \"sean-nós\" singing guides his arrangements of Bunting manuscript pieces, breathing fresh life into Ireland's ancient harp music for contemporary audiences."]
              [:p "Mícheál works three days per week maintaining a successful engineering career in offshore renewables.  He devotes the balance of his working week to his practice of singing with the early Gaelic harp and related generative art. The crossover between Mícheál's parallel artistic and engineering careers find expression in the audiovisual exhibitions and live shows he creates, including the digital artwork shown here."]
              [:p "Mícheál gravitates equally towards the ancient and the emergent.  Applying his strong engineering background, Mícheál codes custom computer algorithms to make and share generative art.  This artwork reflects and nourishes his process of engaging with the early Gaelic harp on the harp's own terms."]
              [:p "As a multimedia artist, Mícheál curates beautiful and unique audiovisual experiences for audiences across three interweaving and artistically fertile strands:"
               [:br] "Historical: historically viable performance of ancient harp tunes and songs from archival manuscripts and collections"
               [:br] "Traditional: collaborative arrangement and performance of early Gaelic harp pieces with established traditional Irish musicians and singers, returning these pieces faithfully to the living tradition"
               [:br] "Contemporary: improvised music and song alongside generative visual and sound art, reimagining the early Gaelic harp in contemporary contexts."]
              [:p "Living in Cork, Mícheál is a recipient of Irish Arts Council Agility (2021), Traditional Arts Bursary (2017) and Deis Recording & Publication (2017) Awards. He has performed solo harp & voice concerts at Achill International Harp Festival and Scoil na gCláirseach Festival of Early Irish Harp, and his generative art has been exhibited at Naas Art & Culture Centre, Galway Arts Centre, and the Lord Mayor's Pavillion in Cork City."]
              [:p "For custom requests or general inquiries get in touch with Mícheál via contact details on his website michealocathain.com."]
              (comment
                [:p "View and collect work from the Mícheál's Lúthchleasa [lu:hxlˈæsə] collection on the Tezos blockchain by scanning the following QR codes:"]
;;; QR code good stuff!
                [:a {:href "../img/art/luthchleasa_documentation/qr-code-beith.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-beith.png", :width "15%"}]]
                [:a {:href "../img/art/luthchleasa_documentation/qr-code-coll.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-coll.png", :width "15%"}]]
                [:a {:href "../img/art/luthchleasa_documentation/qr-code-fearn.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-fearn.png", :width "15%"}]]
                [:a {:href "../img/art/luthchleasa_documentation/qr-code-luis.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-luis.png", :width "15%"}]]
                [:a {:href "../img/art/luthchleasa_documentation/qr-code-sail.png"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/qr-code-sail.png", :width "15%"}]]
                [:p {} [:strong "[NOTE for editors: Click each QR code image for higher resolution (c. 2000x2000px) version for printing.]"]])





              
              ]

             [:div {:class "column" :id "pr"}
              [:h3 {} [:strong {} "A 500-1000 word reflection on your artistic practice, in the context of the artworks which have been selected for the book."]]
                   [:p "Singing is at the centre of my artistic practice. Orbiting this centre is the music of the early Gaelic harp. As a multimedia artist I integrate fine-art digital print, audiovisual installation and live performance to connect outwards from this centre with contemporary audiences. Creating both online and in-real-life (IRL) experiences rooted in the oral traditions I have inherited, I engage the emotions of today's viewer in order to make heart-felt connections with my subject matter, the harmonic nature of singing with harp. I want my audiences to have a visceral, kinesthetic response to my work - only afterwards realising it was made using computer code."]
              [:p "I consider the singing human larynx as an original, primal, embodied technology with infinite possiblilities of movement, sensitively influencing the flow of breath and making it audible through resonance. I make connections between singing and the technology we make - ancient carbon-based technology like the early Gaelic harp and newly emerging silicon-based digital \"Web 3.0\" technologies built on the blockchain concept.  For me the very old and the very new are similarly fertile creative spaces in the global village, folding over each other from opposite ends of the same spectrum."]
              [:p "I don't gravitate towards academic study of early Gaelic harp music. Instead I take an experimental approach, curating experiences of resonance using my own voice and body in collaboration with my harp, and a range of multimedia technologies. I have come to understand that my approach needs to be iterative, improvisational and curious."] 
              [:p "Generative art has an established place in art history, pioneered in contempory settings by such artists as Vera Molnar (visual art) and John Cage (music composition).  The early careers of these artists were in the pre-computer era, when their rule-based algorithms, incorporating chance procedures, were implemented with traditional art forms such as the painted canvas and the orchestra. Nowadays generative art is enjoying a renaissance, created by artists using modern computer languages and presented using a cornucopia of both mature technologies of ever increasing fidelity (such as inkjet printers and multi-channel audio speakers), as well as newer internet-enabled fixed and mobile devices (such as 8K+ smart displays, and smart phones/tablets). Happily, estabished and emerging digital media such as these are ideal playgrounds for generative artists like myself to make and share work, as their evolving designs increasingly afford combined visual and musical forms, and also since these media reach a global audience via the internet browser."] 
              [:p "During a 2017/2018 Irish Arts Council bursary I began painting my emotional response to early Gaelic harp music encoded in the Bunting manuscripts (an example of an early Gaelic harp familiar to most Irish people is the Trinity harp stamped on our coins). Since I have a strong engineering background I subsequently combined this physical artwork with creative coding. I chose the internet browser as my primary medium after researching a broad range of computer languages over the course of 2020 and 2021.  My \"virtual studio\" ecosystem now comprises a text editor called emacs, code written in a computer language called clojurescript, with an internet browser window open on my screen rendering audiovisual outputs from my code as it evolves.  Working in this way I have come to realise how well suited to my process are physical exhibitions and solo harp/voice concerts. This realisation came when I demonstrated to myself that I can render to high-resolution, and then print, the art I make in and for the browser. I access the best of both worlds - the reach and facility of the browser, with the warmth, texture and visual fidelity of fine-art prints.  As well as exhibitions and performances, I find inspiration in sharing my work in progress with like-minded artists. This type of sharing is typical of many generative artists who regularly share work in progress, as do I, on a variety of social media platforms."] 
              [:p "I am drawn to the subject of musical resonance because it is a universal human experience which finds regional and personal expression. This has led me to think about whether the visual art on the Trinity harp - which incorporates circular motifs, Celtic knot-work, gemstones and overlaid lozenges - expresses similar ideas to those represented by the music the harp is designed to play. In my \"Lúthchleasa [lu:hxlˈæsə]\" show I explore this thought with abstract visual forms and sound samples."]
              [:p "I am investigating my belief that there is a link between the resonating patterns expressed in early Gaelic art and harp music.  I believe these patterns are structured on geometric rules, with variation from the rules an idiomatic feature expressible with pervasive randomness.  I don't consider the music collected by Bunting to be a static unchanging set of relics.  Creating his manuscripts, Bunting did an outstanding job preserving the old harp music as he did, with a rich trail of clues as to how his Western classical music interpretation could be reverse-filtered. However if the medium is the message, then the message of a manuscript is that what it contains is unchanging, frozen.  Intuitively I don't believe this to be true of early Gaelic harp music. Thankfully new digital audiovisual media help do justice to expressing this inherently oral tradition on its own terms. I am convinced the musical ideas contained in the Bunting manuscripts, and other related archival collections, represent datapoints in a rich and dynamic spectrum of possibilities. In my  Lúthchleasa [lu:hxlˈæsə] collection, I contemplate this spectrum by coding simple rules which overlay and interact, combining primitive geometric shapes and randomness to generate complex, emergent visuals and music."]  
              [:p "To me, my Lúthchleasa [lu:hxlˈæsə] collection represents a mindfully curated attention echo-chamber, appropriating the latest emerging technology to amplify for myself and for audiences the ideas of resonance as represented in early Gaelic harp music and art. In the process of creating this collection, some ideas crystalised as I hoped while others proved too ambitious in the timescales available and so form the seeds for future work!"]]



             (comment
               [:div {:class "column" :id "hi-res"}
                [:br]
                [:br]
                [:hr]
                [:h1 {} "REFERENCE MATERIAL: Fearn Series"]
                [:h2 {} "Proposal: Micheal kindly requests a link is included to the virtual/online collection of the Fearn series at " [:a {:href "https://objkt.com/collection/KT1C8Mk3F82ueacXfJQwDZfAWsEeqJgFPEob"} "Fearn Collection (Demo) "] ]
                [:p  {}  "Please note this online collection is a demo currently (e.g., only 3 of 15 print images included currently, at low resolution), to aid discussion with Sample Studios regarding this photobook and planned June exhibition."]
                [:h2 {} "High resolution TIF images, titles and information for each individual print in the series"]



                [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with straight edge"]]
                [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
                [:p {} "The prints for the Fearn series have dimensions 141 x 121 mm, identical to the paper Bunting used in his field collecting of the old music from Irish harpers in the period 1792 - ca. 1805."]
                [:p {} "Four " [:em "lúthchleasa"] " are represented in the Fearn series:"]
                [:ul
                 [:li {} [:em "Leagadh anuas"] " , translated from Gaelic to English as \"falling/knocked down from above\". Four prints."]
                 [:li {} [:em "Leath leagadh"] " , translated as \"half-falling\". Three prints."]
                 [:li {} [:em "Brisidh"] " , translated as 'a break'. Six prints"]
                 [:li {} [:em "Crothach aon mhéar"] " , translated as 'one finger shaking'. Two prints"]]
                [:br]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-01--20211123T233014518-seed-3780__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-01-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center;height:80px"}
                  [:span {:style "font-size:12px"} [:em "Leagadh anuas I"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-02--20211123T231136929-seed-5870__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-02-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Leagadh anuas II"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-03--20211123T231205258-seed-8610__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-03-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Leath leagadh I"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-05--20211123T23363162-seed-6280__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-04-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Leagadh anuas III"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-05--20211123T23363162-seed-6280__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-05-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Leath leagadh II"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-06--20211123T231211510-seed-3310__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-06-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Brisidh I"]]
                  [:span {:style "font-size:9px"} [:br] "141x121m" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-07--20211123T231219592-seed-3100__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-07-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Brisidh II"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]

                [:br]
                [:br]
                
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-08--20211123T231328490-seed-3760__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-08-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Crothach aon mhéar I"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-09--20211123T231400875-seed-10__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-09-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Leagadh anuas IV"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-10--20211123T231410615-seed-2830__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-10-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Brisidh III"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-11--20211123T23115222-seed-7440__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-11-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Brisidh IV"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-12--20211123T231423670-seed-6590__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-12-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Leath leagadh III"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-13--20211123T231442414-seed-7370__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-13-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:12px"} [:em "Crothach aon mhéar II"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-14--20211123T231508849-seed-8750__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-14-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:13px"} [:em "Brisidh V"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
                [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
                 [:a {:href "../img/art/luthchleasa_documentation/hi-res/fearn-15--20211123T233753372-seed-3610__5640x4840_GAC-FINAL.tif"}
                  [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-15-thumbnail-framed.png" :width "100%"}]]
                 [:figcaption {:style "text-align:center"}
                  [:span {:style "font-size:13px"} [:em "Brisidh VI"]]
                  [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]              
                [:br]
                [:br]


                
                
                ])
             
             ]]]]
         ])




  )
