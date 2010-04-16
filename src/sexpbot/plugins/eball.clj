(ns sexpbot.plugins.eball
  (:use [sexpbot respond])
  (:require [irclj.irclj :as ircb]))

(def responses
     ["As I see it, yes."
      "It is certain."
      "It is decidedly so."
      "Most likely." 
      "Outlook good." 
      "Signs point to yes."
      "Without a doubt." 
      "Yes."
      "Yes - definitely."
      "You may rely on it." 
      "Reply hazy, try again."
      "Ask again later."
      "Better not tell you now."
      "Cannot predict now."
      "Concentrate and ask again."
      "Don't count on it."
      "My reply is no."
      "My sources say no."
      "Outlook not so good."
      "Very doubtful."])

(defmethod respond :8ball [{:keys [irc nick channel]}]
  (let [answer (rand-int 20)]
    (ircb/send-message irc channel (str nick ": " (nth responses answer)))))

(defplugin {"8ball" :8ball})