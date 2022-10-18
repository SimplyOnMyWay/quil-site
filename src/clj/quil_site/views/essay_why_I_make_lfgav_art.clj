
(ns quil-site.views.essay-why-I-make-lfgav-art
  (:require [quil-site.views.page :refer [page]]))

(defn essay-why-I-make-lfgav-art-page []
  (page {:tab :essay-why-I-make-lfgav-art
         :type :essay-why-I-make-lfgav-art-page
         :js-files []
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
              [:img {:class "hormargins", :src "../img/art/ab/juxt-11-10-2022-1.png", :width "50%"}]

              [:p {} "October 2022"]
              [:br]
              [:p {} "Above all else in the art I make I wish to sing with my voice, freely and with peace of mind"]
              [:br]
              [:p {} "In their book Art and Fear [superscript ref, ideally in sidebar!, like https://jackschaedler.github.io/circles-sines-signals/], authors David Bayles and Ted Orland state that art critics typically ask the following 3 questions:"]
              [:ol {}
               [:li {} "What was the artist's goal?"] 
               [:li {} "Did they achieve this goal?"]
               [:li {} "Was it worth doing?"]]
              [:p {} "As the author David ... says, it is the third question that is the real clincher."]
              [:p {} "In this essay I lay out my top level goals with audiovisual art and come to some conclusions as to whether these goals are worth achieveing."]
              [:p {} "The middle question of whether I achieve my goal is possibly asked in a different way by critics than I choose to ask of myself as I work on my work. Embracing failure is an inherent goal for me in its own right - easier said than done, but an essential habit for taking risks and seeding new ideas! That being said I also value addressing this question objectively for myself as a way to stay true to my intention, including as a way to stay authentic with myself as to how my original goal may have evolved or even changed completely. So while I eshew the black and white assessment of the critic's voice, I do consider in this essay navigation strategies for my generative art (\"navigational aids\") - reliable indicators that allow me feel my way towards my goals, and around pitfalls."]              
              [:p {} "In definining my goals within the medium of long form generative audiovisual art, I find it is equally important to consider what I am (italic not) trying to achieve, as well what I am.  Likewise when I determine whether my goals are worth pursuing, I remain cognisant of the pitfalls as well as the benefits to my process and to what audiences experience."]

              [:br]

              [:h3 "1. Explore affordances specific to web3"]
              [:p {} "So what makes LFGAVA unique and what are my goals for its unique aspects especially?  Understand Media makes the case that all media contains within it the technologies it extends.  As I follow this line of thinking, what becomes compelling as a goal for my own practice is to work with the affordances specific to web3 technology.  Here I mean art which pushes the buttons and pulls the levers specifically afforded by web3 technology, creating emergent effects greater than the sum of the audiovisual information technology it encapsulates. For example, traditionally music videos have been loss making forms of advertising the primary product of a music recording - with web3 music and visuals can be combined in artistically compelling ways which can also be consumed without a pre-defined media format such as mp3, mp4 etc, rather these formats or others can be encapsulated by web3 technologies such as bespoke apps written by the artist."]
              [:p {} "My goal is not to work on ideas which would be better expressed using one of the individual embedded technologies, nested like Babushka dolls within web3 technology. There is a phenomenal body of work by previous artists in the media of paintings, music, film, photography, etc, which I prefer to draw inspiration from as to how they match their ideas so well to their respective medium.  While I subscribe to Kirby Ferguson's idea that everything is a remix, I also like to use my own discretion as to whether I am the one who chooses to remix a particular idea using web3 media, and if so to do it mindfully."
               ]

              [:p {} "Benefits:"]
              [:ol
               [:li "Learning about web3 technologies by creating user experiences to encounter and consume my generative art"]
               [:li "Collaboration opportunities, such as with web3 engineers, web3 online gallery curators, other artists"]
               [:li "Build upon my skills using digital cameras, coding, recording music, painting (the embedded technologies)"]
               ]
              [:p {} "Pitfalls:"]
              [:ol
               [:li "Learning curve"]
               [:li "Hype cycles"]]
              [:p {} "Navigational aids:"]
              [:ol
               [:li "Join supportive community of web3 devs, ideally using clojure(script) to write smart contracts compiled to wasm (clojrians slack?). Being able to connect with devs I admire is a great way to keep on track in a fun way"]
               [:li "Make friends with other artists with who I can discuss whether web3 technology actually adds anything to a concept I'm considering for my work, or if I can leave it alone knowing it has or will be done better by others and I can therefore look in a fresh direction."]]

              
              [:h3 "2. Create calm using web3 tech"]
              [:p {} "I also endeavour to develop a deep experience of creating calm by working on LFGAVA projects which use web3 technologies.  My goal here is not experience for its own sake, but specfically to befriend this emerging and soon to be ubiqutous technology, so that I am less bewildered by it and its effects on my wellbeing in my relationships with myself, with others and with Nature.  Here I am paraphrasing McLuhan's role of the artist to ...   Also reference the essay Calm Technology!"]
              [:p {} "Benefits:"]
              [:ol
               [:li "Using existing platforms that push boundaries of what is possible with web 3.  QQL is a great example, as is the basic Art Block model"]
               [:li "Curate my very own 'transactional' scenarios (ways to guide consumers of my art when they buy/sell my work) by writing my own smart contracts"]]
              [:p {} "Pitfalls:"]
              [:ol
               [:li "Engineering effort takes my focus off making actual art... this exact pitfall seems to have been avoided by Dmitri by postponing writing his own smart contracts around the time he first released Ringers on Art Blocks, and by Tyler Hobbs by collaborating with an experienced web3 engineer and collector Dandelion Wist"]
               [:li "..."]]
              [:p {} "Navigational aids:"]
              [:ol
               [:li "Play with engineering my own smart contracts, especially now post-Merge that Ethereum affords contracts to be written in in c, Rust, (ideally clojure!) and compiled to eWasm. If I'm having fun engineering these smart contracts I'm doing it right!)"]
               [:li "Am I calmer when I listen and look at the art work as it develops, and also calmer by contemplating the guided experiences baked into my own smart contracts"]]
              
              
              [:p {} "I will know I'm approaching this goal if when I think of web3 technology, I think of the flawed beautiful humans who create and use it, awakenging in me feelings of playfulness and an inner sense of consenting to what is good in life, especially that which can only be experienced in Nature when digital devices are left at home!"]
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

              [:br]
              
              [:p {} "3. Befriending my own visual and hearing senses, using both in a equalised, peripheral (soft-focus)  way as when calm and balanced out of doors.  For example I have memories of a mountain walk in Tenerife, of sunlight dappled through a thicket of knotted trees with a soundtrack of bird singing and insects humming. It seems my sense memories are of a multimedia nature!  Within this goal I also aspire to investigate the perceptual idiosyncocies of Human eyes and ears - things like difference tones and impossible colours, which only exist in our minds! Also idiosyncrocies of Nature such as the looming effect, (equivalent sonic mirages... like David Chase's nodes in D&D)"]
              [:p {} "Benefits:"]
              [:ol
               [:li "Huge scope for exploration of perception and physics"]
               [:li "Enrich my sensory world - increasing my sensitivity"]
               [:li "Perhaps my audiovisual senses do not know whether their inputs are analogue or digital? "]]
              
              [:p {} "Pitfalls:"]
              [:ol
               [:li "Over exposing myself to digital, synthesised stimulation"]
               [:li "..."]]
              [:p {} "Navigational aids:"]
              [:ol
               [:li "Build into my art an encouragement to get out into Nature, including outdoor research, performance and exhibitions. Ask myself each week if I have scheduled time outside with my art"]
               [:li "What percentage of my audio visual practice is not generative/digital but using my eyes and ears only ... such as Alaudin's practice of cupping ears?"]]

              [:br]

              [:p {} "Goal 4: As someone with an aptitude for maths and physics, I have spent a good deal of my professional life working with equations and computer code which models physical systems.  Since this is a signficant area of my life to date, and one which I often enjoy (though not always!), I want to incorporate and embrace it into my art practice.  Physical modelling of acoustic instruments ...."]
              [:p {} "Benefits:"]
              [:ol
               [:li "it is accepted wisdom that ones own art can only be made by integrating all the main parts of ones life into the art one makes."]
               [:li "rearranging my life around my art gives my the experience of congruence and honesty especially in how I present myself in my public roles and responsibilities."]]
              [:p {} "Pitfalls:"]
              [:ol
               [:li "taking so long to gain proficiency in multiple dense technical topics (DSP, filters, colour theory, coding languages/libraries) that no compelling or risky art gets made. I.e., become an expert of the engineering involved, but not a practicing artist"]
               [:li "..."]]
              [:p {} "Navigational aids:"]
              [:ol
               [:li "When the technical becomes second nature, engineerign becomes art... equivalent to driving without thinking of what hand and feet are doing, and instead feeling like a big eye floating along the road"]
               [:li "..."]]

              [:p {} "5. To connect with other people making work in progress. Connecting iwth people in role of patrons, collectors. Affordances of web3 tech seem to be what happens when in the presense of immutability when instances of what is made cannot be counterfeited.  This seems to create very rich and rewarding new experiences for human interactions, without necessarily losing out on what is afforded by pre-Web3 technologies."]

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

              [:br]
              
              [:p {} "6. Explore the role of abstraction to primative forms - musically and symbology.  Reintegrating fundamental ideas into my own heard and visual experience of living in the natural world"]
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

              
              [:br]              

              [:p {} "7. Make part of my living - really. Expand...  10 IRL experience per year with live performance, and assoicated virtual exhibtions experiences in the browser / VR.  Travel free - stay close to home, family and friends while making this living.  Travel is for travel (long term), rather than for making my living."]
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

              [:br]

              [:p {} "8. To explore new ways for audiences to experience my composed audiovisual work.  Currently very high percentage of music is consumed in the form of downloaded or streamed mp3's, and video is similar. The digital samples played back are identical each time the play button is pressed.  Generative, reactive and interactive experiences of audiovisual work is more and more possible with Web3 technologies.  My goal is to embrace these options and design my own platforms on which my projects will be experienced by audiences.  (Along with using the platforms which are emerging already such as Async Music, Artblocks, etc).  A key component of these experiences is carefully curated randomness, so that each time play is pressed the experience will be different, to a greater or lesser degree which (in the interactive case) may be controlled by the audience.
"]

              ]]]]]]))

