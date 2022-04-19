(defn send-mail [some-id]
  (try
    (let [clj-props (:mail (config/config-file))
          mail-address (mail-address-from-props clj-props)
          mail (clj->js (create-mail mail-address some-id))
          transporter (.createTransport nodemailer (clj->js clj-props))]
      (.sendMail transporter mail on-mail-sent))
    (catch js/Error e
      (logging/error (.toString e)))))
