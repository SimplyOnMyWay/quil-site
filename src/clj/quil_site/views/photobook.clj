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
              [:h3 {} [:strong {} "Photos"]]
              [:br]                                          
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_54.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_54_1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_56.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_56_1000.jpg", :width "20%"}]]
              [:br]
              [:p "(Accreditation: Photographs by Tom Flanagan, courtesy Galway Arts Centre)"]
              [:br]
              [:p "The title and date of the piece featured in the specified image, as well as any contextual information that might be relevant ... exhibition inclusions, funding acknowledgements etc:"]
                           
              ]
             
             [:div {:class "column" :id "as"}
              [:h3 {} [:strong {} "A 200-300 word description of what is featured in each image, so that they are contextualised for readers"]]
              ;;  A 200-300 word description of what is featured in each image, so that they are contextualised for readers;
              ;;  word count: 122


              [:p "

The photograph shows a series of seven digital archival prints, each 141 x 121 mm on Hahnemuhle Museum Etching paper, presented underneath glass on a display table.

The Fearn series (15 small-format Giclée prints) is one of five series of generative art featured in Mícheál's solo show at Galway Arts Centre in December 2021. The other series, titled Beith, Coll, Luis and Sail, consisted of 16 medium format prints - 400 x 400 mm. The show, which comprised giclée prints, audiovisual installation and live solo performance on harp, voice and electronics, represented Mícheál's emotional response to the music encoded in the Bunting manuscripts, a collection of early Gaelic harp music and songs from the turn of the 1800s.

The 121x142mm dimensions of each piece in the Fearn series are in homage to the dimensions of the collecting field paper of Edward Bunting, while the paper chosen (Hahnemuhle Museum Etching paper) is mindful of the laid-paper technology which had recently emerged at the time Bunting collected this harp music.

During Winter 2021 it was uncertain if the physical exhibition would proceed due to covid lockdown restrictions. Consequently Mícheál created a virtual audiovisual exhibition of the work online, as well as physical fine-art prints and digital display of the images mounted in the physical exhibition space, with accompanying generative audio. Happily in-person viewing of the exhibition went ahead!

The form of the pieces in the Fearn series comprises intersecting music staves and bordered paths reminiscent of Celtic knot-work, with clouds of musical note-heads escaping their confines. 

Mícheál applied a rule-based colour palette, based on a gradient of reds to yellow-greens in \"north to south\" direction, with a gradient of blue-greens to violets in the \"west to east\" direction.

Micheal would like the viewer to approach the work with awareness of their point of view.  He encourages such awareness through his choiceof displaying the pieces in the horizonal (reminiscent to how museum pieces are displayed, e.g., the Book of Kells) rather than the more traditional choice of vertical wall mounting.  By bringing the viewer physically closer to the artwork, Micheal also encourages a sense of curiosity and accessibilty about the harp music represented.

"]




;;               The exhibition consisted of 16 medium format prints of Mícheál's generative artwork (400 x 400 mm, Giclée print on Hahnemühle Museum Etching paper, with deckled edge) comprising four series titled Beith, Coll, Luis and Sail, and 15 smaller Giclée prints (141 x 121 mm, in homage to the dimensions of the collecting field paper of Edward Bunting) comprising one series titled Fearn.

;; The exhibition also included an audiovisual installation element.  The medium for these generative audio-visuals were Raspberry Pi mini-computer / Samsung Crystal 43inch display & speakers.  The installation element comprised five displays, each corresponding to one of the five series (Beith, Coll, Fearn, Luis & Sail).  A much larger set of curated images (ca. 500 in total) were displayed in the audiovisual installation, versus the 36 prints, albeit with consistently high artistic quality across all elements.  Generative audio played from the display speakers.  The artist provided the Raspberry Pi's and peripherals as "plug and play", and the displays were GAC-owned.

;; The solo concert element successfully bridged the exhibition with live performance.  The technical set up at Nuns Island was quite simple - the sound technician plugged a single audio (XLR) cable from my onstage equipment into the house sound, and there was a projector displaying visuals from a laptop provided by the artist.




              
              
              (comment
                [:p "The word Lúthchleasa (athletics) is cast in this exhibition and concert project in a dual musical role, describing at once the feats of fingers on the metal strings of the early Irish harp or cláirseach, and the idiomatic musical patterns that emerge as a result.  Bridging the ancient and the modern, this body of new generative artwork by Mícheál Ó Catháin showcases his process of engaging with the early Irish harp tradition on the harp's own terms.  For over a decade Mícheál has been discovering the shapes and sounds offered to human touch by the metal and wood of this instrument, and the lúthchleasa patterns encoded in the notes penned by a young Edward Bunting at the 1792 Belfast Harp Meeting."])
              
              
              ]


             
             [:div {:class "column" :id "bio"}
              [:h3 {} [:strong {} "A 300-500 word biographical note (written in the third person)"]]

              ;; A 300-500 word biographical note (written in the third person);
              ;; 242
              
              (comment
                [:p {} [:img {:class "alignnone ", :src "../img/micheal/MichealOCathain.IMMA.002.Augmented.1000x979.jpg", :width "68%"}]])

;;; people, this is who I am
;;; highlights of my artistic development, but not detail anyone could get from my resume              
;;; Micheal O'Cathain enjoys telling people he once...
;;; Youghal!
;;; Parallel career...              


              
              [:p "Mícheál is a multimedia artist working primarily with harp & voice performance, computer code, installation. He is a recipient of Irish Arts Council Agility (2021), Traditional Arts Bursary (2017) and Deis Recording & Publication (2017) Awards. Mícheál has performed solo harp & voice concerts at Achill International Harp Festival and Scoil na gCláirseach Festival of Early Irish Harp, and his generative art has been exhibited at Naas Art & Culture Centre and Galway Arts Centre."]

              [:p "Faithful to historical practices, Mícheál sings with the harp on his left shoulder and employs specialised fingernail techniques (" [:em "lúthchleasa"] ") to shape the resonance of these metal-strung instruments. His arrangements of Bunting manuscript pieces, guided by the rhythms of his " [:em "sean-nós"] " singing, breathe fresh life into Ireland's ancient harp music for contemporary audiences."]
              [:p "Mícheál gravitates equally towards the ancient and the emergent.  He codes custom algorithms to make and share generative audiovisual art which reflects and nourishes his process of engaging with the early Gaelic harp on the harp's own terms."]

              [:p "Interpreting the Bunting manuscripts for a contemporary audience, Mícheál employs computer code as a collaborative partner to represent these patterns in visual form and expresses in this generative art his emotional response to the music. Lúthchleasa [lu:hxlˈæsə] illuminates ancient music and celebrates the beauty and colour spaces inhabited by early Irish art, reimagining for today the full spectrum of expression felt and heard by harpers and listeners alike centuries ago."]

              ]



             [:div {:class "column" :id "pr"}
              [:h3 {} [:strong {} "A 500-1000 word reflection on your artistic practice, in the context of the artworks which have been selected for the book."]]


              ;; A 500-1000 word reflection on your artistic practice, in the context of the artworks which have been selected for the book.
              ;; wordcount...


              [:p {} "


              
I am investigating my own intuitive approach to re-animating ancient Irish harping finger-nail techniques, which I collectively refer to as lúthchleasa.  The artwork provides me a framework on which to record my interpretation of these lúthchleasa, the visual medium of generative art serves to represent visually attributes which I map from my physical playing of these techniques on my harp and the sounds which results.

I am communicating my range of responses to the lúthchleasa, representing these responses in visual form to share the emotional, musical, linguistic and physical attributes I associate with each of these lúthchleasa.

Lúthchleasa / Fearn tells the story of my engagement with these fingernail techniques, as I deepen my understanding of these techniques and the musical ideas they represent.  The nature of generative art is that it is iterative, so I expect to build my story into future versions of the code, and the art work which emerges,  as my understanding and playing of these lúthchleasa techniques on my harp evolves.

My process involved coding an algorithm which generates variable outputs, each image unique and repeatable based on a digital signature which determines all randomness in the image. Think of this signature as a seed or DNA for all the variability of the image. From a set of circa 200 unique images generated by the algorithm, I curated 15 images for printing and display in the exhibition on two tables. 7 of these images are shown in the photograph.

The Fearn series of generative artwork represents my emotional response to a specific family of harp techniques (a subset of the full set of lúthchleasa) named in the Bunting as leath leagadh, leagadh anuas, brisidh and crothach aon mhear. From my own experience of playing these techniques, I have grouped them together and assigned (as a memory aid) the ogham symbol Fearn to identify this grouping.

The noteheads escaping from the staves represents the release of the notes from the "straigh-jacket" / limitations of European music notation             

I am investigating my own intuitive approach to re-animating ancient Irish harping finger-nail techniques, which I collectively refer to as lúthchleasa.  The artwork provides me a framework on which to record my interpretation of these lúthchleasa, the visual medium of generative art serves to represent visually attributes which I map from my physical playing of these techniques on my harp and the sounds which results.

;;;; I am breaking apart / separating / categorising the families of techniques, and examining their attributes

;;;; 8. what could I say that might encourage a closer look?
;;;; There is a lot of fine detail in the noteheads
;;;; The attributes of the techniques are mapped to the visuals of each piece in the Fearn series, as indicated by the names

The richness of the early Irish harp and visual art traditions keeps me curious and dedicated, especially how to find contemporary and appropriate settings for expressing the ideas for which this instrument and the music it can make is uniquely suited.

The artwork involved mentorship (both musical with Ann Heymann and visual with Louise Manifold), skills in computer coding of visuals and audio in the browser, travel between Dublin (where I lived at the time) and Galway Arts Centre for site visits and well as production of the exhibition, technology in multiple forms - print, photo, video, computer hardware, remote monitoring of audio visual installation, electronic effects during live performance. 


              ;;;; 3. how did i phyically engage in the creation?
              ;;;; I created the images by sitting at a desk, writing code using a computer keyboard, and viewing the results on a computer screen
              ;;;; Visited the gallery space and through discussions with the gallery team as well as mentorship, decided that displaying the images horizontally rather than the traditional vertical mounting was appropriate, both for the pieces and for architecture of the room.


              ;;;; 5. how am i uniquely presenting the subject?
              ;;;; By presenting the pieces horizontally
              ;;;; By abstracting the notes and staves in the Bunting manuscripts, playing with their structure and introducing colour
              ;;;;              
              ;;;; 6. how did accidents or discoveries lead me to the finished work?
              ;;;; I discovered that carefully introducing randomness into the underlying grid gave a softer more organic feel to the overall composition
              ;;;;              
              ;;;; 7. how did I choose this medium?
              ;;;; I chose the browser as my primary medium by researching a broad range of computer languages over the course of the pandemic.  It became apparent to me how much of human time and attention globally is spent within this browser environment. I also realised how powerful a multimedia medium the browser is already, with additional features being added by browser designers on a daily basis.  A big ah-ha moment was when I demonstrated to myself that I could render to high-resolution and print the art I made in and for the browser, so that I could access the best of both worlds - the reach and facility of the browser with the warmth, texture and visual fidelity of a fine-art print.

              ;;;; 11. how would I like the viewer to approach the work?
              ;;;; With awareness of their point of view, an awareness encouraged by the choice of the artist to display the pieces in the horizonal (reminiscent to how museum pieces are displayed) rather than the more traditional choice of vertical wall mounting 
              ;;;; a curiosity about how accessible we feel the music represented in the art to be


              ;;;; 1. why did I make this?
              ;;;; to map out visually the idea of luthchleasanna
              ;;;; to give each their territory visually, sufficient to explore long term as my understanding of their emotional content evolves
              ;;;; 2. what do I believe in?
I believe that predictable, repeatable human emotional response is hard-coded into the techniques
I believe that these responses can be mapped visually, individually and overlapping             
              
;;;; 3. what belief am I investigating?
I am investigating my belief that there is a link between the ideas expressed visually and sonically in early Irish music and art.  I belive theses ideas are rule-based, geometric, with variability / deviations from the rules expressible with randomness.  I also believe that music collected by Bunting represents datapoints in a broad dynamic spectrum, not static unchanging relics.  I believe that this spectrum can be reconstructed, using digital art forms and ideas of geometry and randomness.

              ;;;; 4. how does personal belief or viewpoint or conviction come through in my art?
              ;;;; primative geometric shapes, random distributions of same, combination of attributes resulting in emergent complexity
              ;;;; linking music and visuals, both in exhibition/installation, and also in live performance
              ;;;; my questioning of conventional interpretations of the music represented in the Bunting manuscripts is expressed in the curation of the Fearn series in GAC, where I chose not to mount the pieces on the wall but rather flat on a display table.

              ;;;; 5. what emotion was primary while I made this artwork?
              ;;;; surprise, wonder, esp when I introdcued randomness into grid of Fearn... carthesis (sail), 

              ;;;; 6. how does emotion come through the work?
              ;;;; colour, juxt of hardlines and relaxed structure, notes "flying" away, released from strait jacket

              ;;;; 7. what was I thinking about during the process?
              ;;;; paths, staves, notes ... Bunting manuscript layers, reverse engineering the layers from the compound image
              ;;;; affordances of the browser - linking soudns and visuals             

              ;;;; 8. what inspired this direction?
              ;;;; Ann convos during Bursary, painting during Bursary, Dan S tuturials, frustration of not relating to accepted wisdom of historically informed practice, 

              ;;;; 9. if the inspiration had no concrete logic, write about that!
              ;;;; i relaxed the need to directly link visuals to music, as this allowed the unknown / gaps in the Bunting music to fill themselves in - also this honoured my own intuition from being imbibed in traditional singing and dance music.
              ;;;;              










"]


              
              
              [:ul
               [:li {} "Music, installation, performance"]
               [:li {} "Engaging with digital archive"]
               [:li {} "Harp"]
               [:li {} "GAC exhib - luthchleas"]
               [:li {} "What ideas Fearn represenation"]
               [:li {} "Size of Bunting notebook"]]




              ;; how and what (don't have to answer every one!)
              ;;;; 1. how did I make this?
              ;;;; with computer code written in a language called clojurescript, and using a graphics library called p5.js (and a audio environment called ChucK - mention in process moreso perhaps!)
              ;;;; working with a fine-art printer to convert the digital pixels in a .tif file to a print on archival paper
              ;;;; 2. how did I use the medium or combine mediums?
              ;;;; Because it was uncertain if the exhibition would be in-person or virtual, I created the work so that it could be viewed online by anyone using an internet browser, as well as printing physical fine-art prints of the images for mounting in the physical exhibition space
              ;;;; By designing my digital canvas in the browser to scale easily to any resolution I wanted, it became feasible to seamlessly combine the two mediums, ie of a LCD screen displaying a digital image on a browser canvas, and a physical print of the same image.
              ;;;;              
              ;;;; 3. how did i phyically engage in the creation?
              ;;;; I created the images by sitting at a desk, writing code using a computer keyboard, and viewing the results on a computer screen
              ;;;; Visited the gallery space and through discussions with the gallery team as well as mentorship, decided that displaying the images horizontally rather than the traditional vertical mounting was appropriate, both for the pieces and for architecture of the room.
              ;;;; 4. how is it constructed?
              ;;;; The tables had been built for a previous Tulca exhibition, glass tops were cut to measure at a local framer on Dominic Street
              ;;;;
              ;;;; 5. how am i uniquely presenting the subject?
              ;;;; By presenting the pieces horizontally
              ;;;; By abstracting the notes and staves in the Bunting manuscripts, playing with their structure and introducing colour
              ;;;;              
              ;;;; 6. how did accidents or discoveries lead me to the finished work?
              ;;;; I discovered that carefully introducing randomness into the underlying grid gave a softer more organic feel to the overall composition
              ;;;;              
              ;;;; 7. how did I choose this medium?
              ;;;; I chose the browser as my primary medium by researching a broad range of computer languages over the course of the pandemic.  It became apparent to me how much of human time and attention globally is spent within this browser environment. I also realised how powerful a multimedia medium the browser is already, with additional features being added by browser designers on a daily basis.  A big ah-ha moment was when I demonstrated to myself that I could render to high-resolution and print the art I made in and for the browser, so that I could access the best of both worlds - the reach and facility of the browser with the warmth, texture and visual fidelity of a fine-art print.
              ;;;;              
              ;;;; 8. how did I choose this subject?
              ;;;; 
              ;;;;              
              ;;;; 9. how did I decide on this direction?
              ;;;;
              ;;;;              
              ;;;; 10. how has exploration brought me to this work?
              ;;;;
              ;;;;              
              ;;;; 11. how would I like the viewer to approach the work?
              ;;;; With awareness of their point of view, an awareness encouraged by the choice of the artist to display the pieces in the horizonal (reminiscent to how museum pieces are displayed) rather than the more traditional choice of vertical wall mounting 
              ;;;; a curiosity about how accessible we feel the music represented in the art to be
              ;;;;               
              ;;;;              
              ;;;; 12. how did I choose my palette?
              ;;;; gradient of reds to yellow-greens in "north to south" direction, with a gradient of blue-greens to violets in the "west to east" direction
              ;;;;              
              ;;;; 13. how would I decribe the continuity or contrast in the work
              ;;;;
              ;;;;              
              ;;;; 14. how does the subject relate to the form, the form to the subject?
              ;;;; The form of the pieces comprises intersecting music staves and paths reminiscent of Celtic knot-work, with clouds of msusical note-heads.  The subject of the Fearn series are four lúthchleasa, with the "action" of these techniques related to the structure and suggested motion of the forms.  The lúthchleasa represented are ...  
              ;;;; The strings of the harp are also suggested by the form
              ;;;; Colour of the pieces represents the emotional content of these techniques
              ;;;;              
              ;;;; 1. what is the viewer looking at?
              ;;;; A series of 7 prints, each 141x121mm on Hahnemuhle archival paper, presented on top of a display table covered with glass
              ;;;;              
              ;;;; 2. what is it made of?
              ;;;; archival ink on Hahnemuhle paper
              ;;;;              
              ;;;; 3. what was my process?
              ;;;; I coded an algorithm which generates variable outputs, each image unique and repeatable based on a digital signature which determines all randomness in the image. Think of this signature as a seed or "DNA" for all the variability of the image. From a set of circa 200 unique images generated by the algorithm, I curated 15 images for printing and display in the exhibition on two tables. 7 of these images are shown in the photograph.
              ;;;;              
              ;;;; 4. what does it represent?
              ;;;; The Fearn series of generative artwork represents my emotional response to a specific family of harp techniques (a subset of the full set of lúthchleasa) named in the Bunting as leath leagadh, leagadh anuas, brisidh and crothach aon mhear. From my own experience of playing these techniques, I have grouped them together and assigned (as a memory aid) the ogham symbol Fearn to identify this grouping.
              ;;;; The noteheads "escaping" from the staves represents the release of the notes from the "straigh-jacket" / limitations of European music notation             
              ;;;; 5. what am I investigating?
              ;;;; I am investigating my own intuitive approach to re-animating ancient Irish harping finger-nail techniques, which I collectively refer to as lúthchleasa.  The artwork provides me a framework on which to record my interpretation of these lúthchleasa, the visual medium of generative art serves to represent visually attributes which I map from my physical playing of these techniques on my harp and the sounds which results.
              ;;;;              
              ;;;; 6. what am I combining or breaking apart?
              ;;;; I am breaking apart / separating / categorising the families of techniques, and examining their attributes
              ;;;;              
              ;;;; 7. what was the initial inspiration and where the it lead?
              ;;;; 
              ;;;;              
              ;;;; 8. what could I say that might encourage a closer look?
              ;;;; There is a lot of fine detail in the noteheads
              ;;;; The attributes of the techniques are mapped to the visuals of each piece in the Fearn series, as indicated by the names of each piece.             
              ;;;; 9. what am I communicating?
              ;;;; I am communicating my range of responses to the lúthchleasa, representing these responses in visual form to share the emotional, musical, linguistic and physical attributes I associate with each of these lúthchleasa.
              ;;;;              
              ;;;; 10. what story does it tell?
              ;;;; It tells the story of my engagement with these lúthchleasa, as I deepen my understanding of these techniques and the musical ideas they represent.  The nature of generative art is that it is iterative, so I expect to build my story into future versions of the code, and the art work which emerges,  as my understanding and playing of these lúthchleasa techniques on my harp evolves.
              ;;;;              
              ;;;; 11. what did I learn while making it?
              ;;;; 
              ;;;;              
              ;;;; 12. what pervades the work?
              ;;;;
              ;;;;              
              ;;;; 13. what qualities characterises the work
              ;;;;
              ;;;;              
              ;;;; 14. what did I accomplish
              ;;;;
              ;;;;              
              ;;;; 15. what keeps me curious, dedicated or obsessed?
              ;;;; The richness of the early Irish harp and visual art traditions keeps me curious and dedicated, especially how to find contemporary and appropriate settings for expressing the ideas for which this instrument and the music it can make is uniquely suited.
              ;;;;              
              ;;;; 16. what was involved? collarboration, tools, skills, travel, research, technoclogy, more than one attempt?
              ;;;; The artwork involved mentorship (both musical with Ann Heymann and visual with Louise Manifold), skills in computer coding of visuals and audio in the browser, travel between Dublin (where I lived at the time) and Galway Arts Centre for site visits and well as production of the exhibition, technology in multiple forms - print, photo, video, computer hardware, remote monitoring of audio visual installation, electronic effects during live performance. 
              ;;;;              
              
              
              ;; why (intention, i.e., my understanding of my work)
              ;;; if struggling with expressing thinking behind my artwork, focus my writing on physical making of my work, the process, or development of form
              ;;; also what drives me to express myself visually / sonically
              ;;; it is possible to be abstract in my ideas while still being concrete in my language
              ;;; bring out inner ambassador, enthusiast, teacher...(or best communicator I know)... keep inner critic at arms' length!
              ;;;
              ;;;; 1. why did I make this?
              ;;;; to map out visually the idea of luthchleasanna
              ;;;; to give each their territory visually, sufficient to explore long term as my understanding of their emotional content evolves
              ;;;; 2. what do I believe in?
              ;;;; predictable, repeatable human emotional response is hard-coded into the techniques
              ;;;; these responses can be mapped visually, individually and overlapping             
              ;;;; 3. what belief am I investigating?
              ;;;; there is a link between the ideas expressed visually and sonically in early Irish music and art
              ;;;; theses ideas are rule-based, geometric, with variability / deviations from the rules expressible with randomness
              ;;;; that music collected by Bunting represents datapoints in a broad dynamic spectrum, not static unchanging relics
              ;;;; this spectrum can be reconstructed, using digital art forms and ideas of geometry and randomness
              ;;;; 4. how does personal belief or viewpoint or conviction come through in my art?
              ;;;; primative geometric shapes, random distributions of same, combination of attributes resulting in emergent complexity
              ;;;; linking music and visuals, both in exhibition/installation, and also in live performance
              ;;;; my questioning of conventional interpretations of the music represented in the Bunting manuscripts is expressed in the curation of the Fearn series in GAC, where I chose not to mount the pieces on the wall but rather flat on a display table.
              ;;;; 5. what emotion was primary while I made this artwork?
              ;;;; surprise, wonder, esp when I introdcued randomness into grid of Fearn... carthesis (sail), 
              ;;;;              
              ;;;; 6. how does emotion come through the work?
              ;;;; colour, juxt of hardlines and relaxed structure, notes "flying" away, released from strait jacket
              ;;;;              
              ;;;; 7. what was I thinking about during the process?
              ;;;; paths, staves, notes ... Bunting manuscript layers, reverse engineering the layers from the compound image
              ;;;; affordances of the browser - linking soudns and visuals             
              ;;;; 8. what inspired this direction?
              ;;;; Ann convos during Bursary, painting during Bursary, Dan S tuturials, frustration of not relating to accepted wisdom of historically informed practice, 
              ;;;;              
              ;;;; 9. if the inspiration had no concrete logic, write about that!
              ;;;; i relaxed the need to directly link visuals to music, as this allowed the unknown / gaps in the Bunting music to fill themselves in - also this honoured my own intuition from being imbibed in traditional singing and dance music.
              ;;;;              



              
              ;; fill in the blanks

              ;;; 1. I work in ... form/medium/theme because it allows me to ... [action/expression]
              ;;; 1. I work in generative art, installation and performance because it allows me to engage with diverse contemporary audiences to reanimate the richness of ideas represented in early Irish harp music, song and art.
              
              ;;; 2. I ... [verb] the viewer in order to ... [state my intention]
              ;;; 2. I engage the emotions of the viewer in order to make heart-felts connections with my subject matter, the resonance of singing and harp music.

              ;;; 3. I created ... [the work] to express my ... [belive/emotion/idea] concerning/and ... [the situation/inspiration]
              ;;; 3. I created the Lúthchleasa exhibition to express my emotional response to the music encoded in the Bunting manuscripts.
              ;;; 3. I created the Fearn series to express my visual mapping of musical attributes associated with four specific fingernail techniques (Lúthchleasa) recorded by Bunting from the last of the early Irish harpers in the 1790s.

              ;;; 4.  .... [clearly describe a particular piece in the show] is based on [reference or experience]
              ;;; 4.  The 121x142mm dimensions of each piece in the Fearn series is based on the dimensions of Edward Bunting's field notebook, while the paper chosen () is mindful of the laid-paper technology which had recently emerged at the time Bunting collected this harp music. 

              ;;; 5. I am drawn to the subject ... because ...
              ;;; 5. I am drawn to the subject of musical resonance because it is a universal human experience which finds regional and personal expression.
              ;;; 5. I am drawn to the subject of early Irish harp, song and art because of my conviction that they respresent ancient forms of soul nourishment which remain relevant today. 
              
              ;;; 6. In the process of creating this work, ...
              ;;; 6. In the process of creating this work, I gained the experience of successfully delivering an ambitious multimedia exhibtion.
              ;;; 6. In the process of creating this work, some ideas crystalised as I hoped while others proved too technically challenging and formed the seeds for future work.

              ;;; 7. I want my viewer to ...
              ;;; 7. I want my viewer to have a visceral, heart-felt response to my work; only afterwards realising/learning it was created using computer code.

              ;;; 8. I discovered that my approach needed to be ....
              ;;; 8. I discovered that my approach needed to be iterative and experimental
              ;;; 8. I discovered that my approach needed to be of the hand-curated variety rather than of the long form variety, given both the artisic and technical challenges of the latter.              

              ;;; 9. I find inspiration ...
              ;;; 9. I find inspiration in sharing my work in progress with like-minded artists; this type of sharing is the M.O. of many generative artists who regularly share their work in progress, as do I, on a variety of social media platforms.

              
              ;;; 10. ... is at the centre of my art
              ;;; 10. Singing is at the centre of my art
              ;;; 10. Breathing and resonance is at the centre of my art                            

              ;;; 11. I don't ..., instead I ...
              ;;; 11. I don't gravitate towards academic study of early Irish harp music, instead I take an experimental approach, curating experiences of resonance using my own voice and body in collaboration with my harp, and a range of multimedia technologies.
              
              ;;; 12. My work is a combination of ... and ...
              ;;; 12. My work is a combination of play and cultural inheritance.
              
              ;;; 13. To me the most important thing is ...
              ;;; 13. To me the most important thing is singing.              

              ;;; 14. I make connections between ... and ...
              ;;; 14. I make connections between singing and technology - ancient techology like the early Gaelic harp and emerging technology like web3 / blockchain.

              ;;; 15. To me this represents ...
              ;;; 15. To me this (show) represents a mindfully curated attention echo-chamber, appropriating the latest emerging technology to amplify for myself and for the viewer - even for a short while - the ideas represented in early Gaelic harp music and art.

              ;;; 16. I was thinking about ... and I created ...
              ;;; 16. I was thinking about whether the art on the trinity harp represents the same ideas as those represented by the music it is designed for, and I created the Lúthchleasa exhibition which explores this idea with abstract forms and sound samples.


              ;; Structures:
              ;;; storytelling - beginning, middle and end
              ;;; medium / process / understanding of the work (with strong, attention grabbing, end sentence)
              ;;; field notes (use words to create curiosity, share info and provoke closer examination of subject and form)
              ;;;; para to describe where you are, or what exploiring (the general caption)
              ;;;; notes re individual pieces (with attributes)
              ;;; (always lead back to what viewers are seeing)
              
              ]




             [:div {:class "column" :id "hi-res"}
              [:h3 {} "Fearn generative art"]


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


              
              
              ]
             
             ]]]]]
        ))


;;; In recent years...Micheal has integrated digital art skills with his [existing] strong background in harp/voice performance
;;; As a multimedia artist, Micheal curates beautiful and unique audiovisual experiences for audiences across three interweaving and artistically fertile strands:
;;; Historical: historically viable performance of ancient harp pieces from archival manuscripts and collections
;;; Traditional: arrangement and performance of historical repertoire, returning these pieces faithfully into the common repertoire
;;; Contemporary: performance of improvised music, with associated generative artwork and digital sound art, bringing the early Irish harp;;; into a wider context (than purely historical or traditional) for contemporary audiences
;;; *ambitious*
;;; Micheal develops and programs algorithms (computer code) representing rules [within which unique visual art pieces are generated]
;;; generative visual art reacts in real time to sampled or generated harp audio...
;;; carefully incorporating randomness so that audiovisual experience is ever-evolving and unique
;;; high quality digital archival prints, working with fine-art printers (and framers)
;;; situating his digital art in the arc of art-history ... contemplating the place of generative coded art in the wider arc of art-history...
;;; using computer code as a medium for padding out the full spectrum of viable possibilities suggested by the sparse archive of harp music
;;; engaging with the digital archive using digital tools
;;; engaging with the affordances emerging digital software and hardware... (ref essay), to create immersive audiovisual installation experiences for audiences
;;; During a 2017 Traditional Arts Bursary Micheal began painting his emotional response to music encoded in the Bunting harp manuscripts. A 2020 Kildare Council [Local Authority Arts] Grant saw Micheal combining this physical artwork with creative coding, drawing on his engineering background, towards and exhibition and concert at Naas Arts & Culture Centre.  ...expand this to Galway Arts Centre...
;;; Micheal is an emerging multimedia artist working with live harp & voice performance and audiovisual exhibitions.
;;; Micheal has performed as a singer and fiddle player for decades, a foundation upon which he has established a deep practice since 2011 with the early Irish harp.  [Mention time split / parallel careers?]

;;; coffee fodder...
;;;; my art is about / my art reconciles the locally disintegrating with the globally emerging ... (6 words)
;;;; my art is about explaining my culture to myself (5 words)
;;;; my art is about contextualising my cultural inheritance.... (4 words)
;;;; my art is about loving every breath... (3 words)
;;;; my art is about singing colours ... (2 words)
;;;; my art is about singing (1 word)

;;; Seamus Begley's story on Se mo laoch about his mother waiting to be asked to sing, and being annoyed when not asked - needing the right social context to be sufficiently relaxed to sing (knowing she couldn't rightly be judged?) ... a very particular Irish context even though she sang pop songs and with vibrato...  A universally human experience - we all need to feel we have fulfilled certain social conditions (norms) before we can "sing".  Art helps (me  /  us) navigate and find these balances
;;;

;;; choosing a few, well chosen words about what I do is a way of being considerate towards my listeners, because they can always ask more questions, and of making me sound more confident.
;;; speak up! confidence and enthusiasm are the very best self-promotion tools

;;; prepare something brief to say about yourself and your work
;;; the way you speak about yourself and your work sends people to the intended destination: your art!
;;; the handshake speech: (implies some kind of connection takes place - imagine someone extending their hand to me... a stranger... a gallery owner, collector...)
;;; a performance, write my lines, know my lines!
;;; .....
;;;; Hi, my name is ... , I'm an artist
;;;; I work in ... mediums
;;;; My art is about ....
;;;; Right now I'm working on ....
;;;; I live ... place, my studio is .... place
;;;; You can see my work [online or gallery]
;;; This is a good time to hand them a business card
;;; Really important to be prepared to ask a question, e.g., Are you an artist
;;; If quezy with all the sales pitch, remember my art is the treasure and everything else is the map :)
;;; rehearse out loud! don't miss opportunities to make connections and sales through lack of prep

